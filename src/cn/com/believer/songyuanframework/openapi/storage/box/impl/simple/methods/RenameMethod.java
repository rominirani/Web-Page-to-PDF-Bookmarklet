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
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RenameRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RenameResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class RenameMethod extends BaseBoxMethod {

    /**
     * This method renames a file or folder.
     * 
     * 'target' param can be either 'file' or 'folder' depending on what you
     * want to rename, 'target_id' is the id of a file or folder to be renamed,
     * 'new_name' is the new name for a file or folder.
     * 
     * On a successful result, status will be 's_rename_node'. If result wasn't
     * successful, stat's field can be: 'e_rename_node', 'not_logged_in',
     * 'application_restricted'.
     * 
     * @param renameRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public RenameResponse rename(RenameRequest renameRequest)
            throws IOException, BoxException {
        RenameResponse baseBoxResponse = BoxResponseFactory
                .createRenameResponse();

        String apiKey = renameRequest.getApiKey();
        String authToken = renameRequest.getAuthToken();
        String target = renameRequest.getTarget();
        String targetId = renameRequest.getTargetId();
        String newName = renameRequest.getNewName();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {

            URLCodec codec = new URLCodec();
            newName = codec.encode(newName, "ISO-8859-1");
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_RENAME);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(authToken);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_TARGET);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(target);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_TARGET_ID);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(targetId);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_NEW_NAME);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(newName);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_S_RENAME_NODE.equals(status)) {
//                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(baseBoxResponse.getStatus());
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
            Element targetElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_TARGET);
            Element targetIdElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_TARGET_ID);
            Element newNameElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_NEW_NAME);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(targetElm);
            requestElm.add(targetIdElm);
            requestElm.add(newNameElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_RENAME);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            targetElm.setText(target);
            targetIdElm.setText(targetId);
            newNameElm.setText(newName);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_S_RENAME_NODE.equals(status)) {
//                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(baseBoxResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP
                .equals(apiRequestFormat)) {

        } else {
        }
        return baseBoxResponse;

    }
}
