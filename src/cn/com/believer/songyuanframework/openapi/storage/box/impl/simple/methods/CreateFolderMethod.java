/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.methods;

import java.io.IOException;

import org.apache.commons.codec.net.URLCodec;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CreateFolderRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CreateFolderResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.utils.ConverterUtils;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFolder;

/**
 * @author Jimmy
 * 
 */
public class CreateFolderMethod extends BaseBoxMethod {

    /**
     * This method creates a new folder.
     * 
     * 'parent_id' param is the id of a folder in which a new folder will be
     * created, 'name' param is the name of a new folder. Set 'share' to 1 if
     * you want to share a folder publicly.
     * 
     * On a successful result, the status will be 'create_ok'.
     * 
     * If the result wasn't successful, status field can be:
     * 'e_no_parent_folder', 'not_logged_in', 'application_r'stricted'.
     * 
     * @param createFolderRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public CreateFolderResponse createFolder(
            CreateFolderRequest createFolderRequest) throws IOException,
            BoxException {
        CreateFolderResponse createFolderResponse = BoxResponseFactory
                .createCreateFolderResponse();

        String apiKey = createFolderRequest.getApiKey();
        String authToken = createFolderRequest.getAuthToken();
        String name = createFolderRequest.getFolderName();
        String parentFolderId = createFolderRequest.getParentFolderId();
        boolean share = createFolderRequest.isShare();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {

            URLCodec codec = new URLCodec();
            name = codec.encode(name, "ISO-8859-1");
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_CREATE_FOLDER);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(authToken);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_PARENT_ID);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(parentFolderId);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_NAME);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(name);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_SHARE);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            if (share) {
                urlBuff.append("1");
            } else {
                urlBuff.append("0");
            }
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                createFolderResponse.setStatus(status);
                if (BoxConstant.STATUS_CREATE_OK.equals(status)) {
                    Element folderElm = responseElm
                            .element(BoxConstant.PARAM_NAME_FOLDER);
                    BoxFolder soapFolder = ConverterUtils
                            .toBoxFolder(folderElm);
                    createFolderResponse.setFolder(soapFolder);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(createFolderResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_XML
                .equals(apiRequestFormat)) {
            Document document = DocumentHelper.createDocument();
            Element requestElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_REQUEST);
            document.add(requestElm);

            Element actionElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_ACTION);
            Element apiKeyElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_API_KEY);
            Element authTokenElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            Element parentIdElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_PARENT_ID);
            Element nameElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_NAME);
            Element shareElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_SHARE);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(parentIdElm);
            requestElm.add(nameElm);
            requestElm.add(shareElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_CREATE_FOLDER);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            parentIdElm.setText(parentFolderId);
            nameElm.setText(name);
            if (share) {
                shareElm.setText("1");
            } else {
                shareElm.setText("0");
            }
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());

            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                createFolderResponse.setStatus(status);
                if (BoxConstant.STATUS_CREATE_OK.equals(status)) {
                    Element folderElm = responseElm
                            .element(BoxConstant.PARAM_NAME_FOLDER);
                    BoxFolder soapFolder = ConverterUtils
                            .toBoxFolder(folderElm);
                    createFolderResponse.setFolder(soapFolder);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(createFolderResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP
                .equals(apiRequestFormat)) {

        } else {
        }
        return createFolderResponse;

    }
}
