/**
 * This is the servlet that does the following:
 * 1) Generating the PDF from Web page content
 * 2) Saving the file in the Web Page PDFs folder in the Box Account
 * 
 * It uses the following libraries:
 * 1) YaHP Converter (http://www.allcolor.org/YaHPConverter/) : To Convert a HTML page into PDF Content
 * 2) Box4j : An Open Source Java library for Box.net (http://code.google.com/p/box4j/)
 * 
 * The high level flow is as follows:
 * 1) The url of the page to be converted is passed to this servlet. Use the YAHP Converter to read the contents of the Web Page and convert to PDF
 * 2) Use the Box4J library to login to box, check if Web Page PDFs folder is present for that account (if not create it) and upload the file in that folder
 */
package com.mindstorm.pdfboomarklet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.tree.DefaultMutableTreeNode;

import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;

import cn.com.believer.songyuanframework.openapi.storage.box.BoxExternalAPI;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxRequestFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CreateFolderRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CreateFolderResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.UploadRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.UploadResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.SimpleBoxImpl;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxAbstractFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.UploadResult;

@SuppressWarnings("serial")
public class PDFGenServlet extends HttpServlet {
	private static final String API_KEY = "#YOUR_BOXAPP_API_KEY#";
	private static final String BOX_PDF_FOLDER = "Web Page PDFs";
	private static final String BOX_FOLDER_EXISTS = "s_folder_exists";
	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Extract out the parameters
		HttpSession session = request.getSession();
		String url = (String)session.getAttribute("url");
		String title = (String)session.getAttribute("title");
		String authToken = (String)request.getParameter("auth_token");
		if (authToken == null) {
			//Check if it is present in the session since it might have come through a validated login
			authToken = (String)session.getAttribute("authToken");
		}
		session.setAttribute("authToken", authToken);
		
		response.setContentType("text/html");
		response.getWriter().println("<h1><a href=\"http://www.cloudspokes.com/challenges/1407\">CloudSpokes Challenge</a> : PDF to Box Bookmarklet for Box</h1>");

		response.getWriter().println("The following PDF is going to be generated:<br/>");
		response.getWriter().println("URL:" + url + "<br/>");
		response.getWriter().println("TITLE:" + title + "<br/>");
		try {
			//Invoke the generatePDF method
			generatePDF(url,title,authToken,response);
		} catch (Exception e) {
			response.getWriter().println("PDF could not be generated. Reason : " + e.getMessage());
		}
	}
	
	/**
	 * This method generates the PDF file from the web page content, uploads the file into Box Account (Folder = Web Page PDFs)
	 * @param url The url of the web page to be converted to PDF
	 * @param title The title of the web page to be converted to PDF
	 * @param authToken The Box Authorization Token
	 * @param response The HTTP Response object to send back status messages back to thr browser
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void generatePDF(String url, String title, String authToken, HttpServletResponse response) throws Exception {
		try {
			//Use the YaHP Converter class to generate the PDF
			CYaHPConverter converter = new CYaHPConverter();
			//First we generate the file name for our web page, we extract out the http:// and other / characters.
			String filename = url.replaceAll("http://", "");
			filename = filename.replaceAll("/", "-");
			File fout = File.createTempFile(filename,".pdf");
			System.out.println(fout.getAbsolutePath());
	        FileOutputStream out = new FileOutputStream(fout);
	        Map properties = new HashMap();
	        List headerFooterList = new ArrayList();
	
	        properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
	        converter.convertToPdf(new URL(url),IHtmlToPdfTransformer.A4P, headerFooterList, out,properties);
	        out.flush();
	        out.close();
	        response.getWriter().println("<b>Step 1</b> : PDF File Generated successfully." + "<br/>");
	        
	        //Once the file has been generated, we need to Create the Web Page PDFs folder. If the folder is present 
	        //it will give back a status message "s_folder_exists"
	        
	        BoxExternalAPI iBoxExternalAPI = new SimpleBoxImpl();
	     // create a folder
	        CreateFolderRequest createFolderRequest = BoxRequestFactory.createCreateFolderRequest(API_KEY,authToken, "0", BOX_PDF_FOLDER, false);
	        CreateFolderResponse createFolderResponse = iBoxExternalAPI.createFolder(createFolderRequest);
	        String createdFolderId = "NA";
	        String strCreateFolderResponse = createFolderResponse.getStatus();
	        if (strCreateFolderResponse.equals(BOX_FOLDER_EXISTS)) {
	        	//If folder exists, then we need to retrieve the Account Tree at the top level and determine the Folder Id
	        	String[] params = {"onelevel","nofiles","nozip"};
	            GetAccountTreeRequest getAccountTreeRequest = BoxRequestFactory.createGetAccountTreeRequest(API_KEY, authToken, "0", params);
	            GetAccountTreeResponse GATR = iBoxExternalAPI.getAccountTree(getAccountTreeRequest);
	            Enumeration e = GATR.getTree().breadthFirstEnumeration();
	            while (e.hasMoreElements()) {
	            	DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) e.nextElement();
	            	BoxAbstractFile aFile = (BoxAbstractFile) treeNode.getUserObject();
	    			String strFolderName = aFile.getName();
	    			if (strFolderName.equals(BOX_PDF_FOLDER)) {
	    				createdFolderId = aFile.getId();
	    				break;
	    			}
	    		}
	        }
	        else {
	        	createdFolderId = createFolderResponse.getFolder().getFolderId();
	        }
	        
	        if (createdFolderId.equals("NA")) throw new Exception("Could not reference the Web Page PDFs folder.");
	        
	        
	        //Now that we have the Box Folder Id for "Web Page PDFs", we upload the file.
	        Map fileMap = new HashMap();
	        fileMap.put(fout.getName(), fout);
	        UploadRequest uploadRequest = BoxRequestFactory.createUploadRequest(authToken, true, createdFolderId,
	                fileMap);
	        UploadResponse uploadResponse = iBoxExternalAPI.upload(uploadRequest);

	        UploadResult uploadResult = (UploadResult) uploadResponse.getUploadResultList().get(0);
	        String uploadedFileName = uploadResult.getFile().getFileName();
	        response.getWriter().println("<b>Step 2</b> : " + "PDF File saved successfully in " + BOX_PDF_FOLDER + " folder in your Box account with filename = " + uploadedFileName + "<br/>");
	        
		}
		catch (Exception ex) {
			response.getWriter().println("Exception in generating PDF File. Reason : " + ex.getMessage());
		}
	}
}