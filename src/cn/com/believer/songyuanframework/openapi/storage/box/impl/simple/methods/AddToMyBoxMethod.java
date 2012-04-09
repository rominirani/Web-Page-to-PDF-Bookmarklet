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
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToMyBoxRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToMyBoxResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class AddToMyBoxMethod extends BaseBoxMethod {

    /**
     * This method copies a file publicly shared by someone to a user's mybox.
     * 'file_id' and 'public_name' params identify a publicly shared file, you
     * should provide either file_id or public name (like '31nhke0ahp') as a
     * parameter. 'folder_id' is the id of a user's folder, where files are to
     * be copied.
     * 
     * On a successful result, the status will be 'addtomybox_ok'. If the result
     * wasn't successful, the status field can be: 'addtomybox_error',
     * 'not_logged_id', 'application_restricted', 's_link_exists'.
     * 
     * @param addToMyBoxRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public AddToMyBoxResponse addToMyBox(AddToMyBoxRequest addToMyBoxRequest)
            throws IOException, BoxException {
        AddToMyBoxResponse addToMyBoxResponse = BoxResponseFactory
                .createAddToMyBoxResponse();

        String apiKey = addToMyBoxRequest.getApiKey();
        String authToken = addToMyBoxRequest.getAuthToken();
        String fileId = addToMyBoxRequest.getFileId();
        String publicName = addToMyBoxRequest.getPublicName();
        String folderId = addToMyBoxRequest.getFolderId();
        String[] tags = addToMyBoxRequest.getTags();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {

            URLCodec codec = new URLCodec();
            publicName = codec.encode(publicName, "ISO-8859-1");
            if (tags != null) {
                for (int i = 0; i < tags.length; i++) {
                    String tag = tags[i];
                    tag = codec.encode(tag, "ISO-8859-1");
                    tags[i] = tag;
                }
            }
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_ADD_TO_MYBOX);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(authToken);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_FILE_ID);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(fileId);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_PUBLIC_NAME);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(publicName);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_FOLDER_ID);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(folderId);
            if (tags == null) {
                urlBuff.append(BoxConstant.AND_SIGN_STRING);
                urlBuff.append(BoxConstant.PARAM_NAME_PARAMS_TAGS);
                urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            } else {
                for (int i = 0; i < tags.length; i++) {
                    String tag = tags[i];
                    urlBuff.append(BoxConstant.AND_SIGN_STRING);
                    urlBuff.append(BoxConstant.PARAM_NAME_PARAMS_TAGS);
                    urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
                    urlBuff.append(tag);
                }
            }
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                addToMyBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_ADD_TO_MY_BOX_OK.equals(status)) {
//                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(addToMyBoxResponse.getStatus());
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
            Element fileIdElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_FILE_ID);
            Element publicNameElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_PUBLIC_NAME);
            Element folderIdElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_FOLDER_ID);
            Element tagsElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_TAGS);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(fileIdElm);
            requestElm.add(publicNameElm);
            requestElm.add(folderIdElm);
            requestElm.add(tagsElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_ADD_TO_MYBOX);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            fileIdElm.setText(fileId);
            publicNameElm.setText(publicName);
            folderIdElm.setText(folderId);
            if (tags != null) {
                for (int i = 0; i < tags.length; i++) {
                    String tag = tags[i];
                    Element tagElm = DocumentHelper
                            .createElement(BoxConstant.PARAM_NAME_ITEM);
                    tagElm.setText(tag);
                    tagsElm.add(tagElm);
                }
            }
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());

            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                addToMyBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_ADD_TO_MY_BOX_OK.equals(status)) {
//                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(addToMyBoxResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP
                .equals(apiRequestFormat)) {
//
        } else {
        }
        return addToMyBoxResponse;
    }
}
