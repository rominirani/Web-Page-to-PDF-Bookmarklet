/**
 * This is the servlet that is invoked by the Bookmarklet. 
 * The Bookmarklet passes the title and url of the page that we want to convert to a PDF.
 * These are passed as Request parameters
 * 
 * The main functionality in this Bookmarklet is to check if the user is already authorized with Box.
 * If not, it will perform the entire Box authorization dance
 * 1) Get a Ticket
 * 2) Get the Authentication URL i.e. http://www.box.net/api/1.0/auth/<ticket>
 * 
 * If the user is already authorized, it will simply invoke the /pdfgen Servlet (PDFGenServlet) that does the following:
 * 1) Generating the PDF from Web page content
 * 2) Saving the file in the Web Page PDFs folder in the Box Account
 */
package com.mindstorm.pdfboomarklet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.believer.songyuanframework.openapi.storage.box.BoxExternalAPI;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxRequestFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.SimpleBoxImpl;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;



@SuppressWarnings("serial")
public class BookmarkletServlet extends HttpServlet {
	private static final String API_KEY = "#YOUR_BOXAPP_API_KEY#";
	private static final String BoxAuthURL = "http://www.box.net/api/1.0/auth/";
	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
        BoxExternalAPI iBoxExternalAPI = new SimpleBoxImpl();
		response.setContentType("text/plain");
		
		//Extract out the parameters
		String url = (String)request.getParameter("url");
		String title = (String)request.getParameter("title");
		
		response.getWriter().println(url);
		response.getWriter().println(title);
		
		//Check if token is present in the session
		HttpSession session = request.getSession();
		String authToken = (String) session.getAttribute("authToken");
		if (authToken == null) {
			// get a ticket by API key.
	        GetTicketRequest getTicketRequest = BoxRequestFactory.createGetTicketRequest(API_KEY);
	        GetTicketResponse getTicketResponse;
			try {
				getTicketResponse = iBoxExternalAPI.getTicket(getTicketRequest);
				session.setAttribute("url",url);
				session.setAttribute("title", title);
		        // after you get the ticket, you need to navigate to the URL
				response.sendRedirect(BoxAuthURL + getTicketResponse.getTicket());
			} catch (BoxException e) {
				response.getWriter().println("Exception in generating PDF File. Reason : " + e.getMessage());
			}
		}
		else {
			//Token is present (User is authenticated already), simply redirect to the pdfgen endpoint i.e. PDFGenServlet
			session.setAttribute("url",url);
			session.setAttribute("title", title);
			session.setAttribute("authToken",authToken);
			response.sendRedirect("pdfgen");
		}
	}
}
