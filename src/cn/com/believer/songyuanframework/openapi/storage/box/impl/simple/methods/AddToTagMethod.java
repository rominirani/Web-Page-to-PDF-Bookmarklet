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
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToTagRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToTagResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class AddToTagMethod extends BaseBoxMethod {

    /**
     * This method adds file or folder to tags list. 'target' param can be
     * either 'file' or 'folder' depending on what do you want to add,
     * 'target_id' is the id of a file or folder to be added, 'tags' array of
     * tags where target will be added.
     * 
     * On successful a result, you will receive 'addtotag_ok'. If the result
     * wasn't successful, status field can be: addtotag_error.
     * 
     * @param addToTagRequest
     *            request
     * @return response
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    public AddToTagResponse addToTag(AddToTagRequest addToTagRequest)
            throws IOException, BoxException {
        AddToTagResponse baseBoxResponse = BoxResponseFactory
                .createAddToTagResponse();

        String apiKey = addToTagRequest.getApiKey();
        String authToken = addToTagRequest.getAuthToken();
        String target = addToTagRequest.getTarget();
        String targetId = addToTagRequest.getTargetId();
        String[] tags = addToTagRequest.getTags();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {

            URLCodec codec = new URLCodec();
            if (tags != null) {
                for (int i = 0; i < tags.length; i++) {
                    String tag = tags[i];
                    tag = codec.encode(tag, "ISO-8859-1");
                    tags[i] = tag;
                }
            }
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_ADD_TO_TAG);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(authToken);
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
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_TARGET);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(target);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_TARGET_ID);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(targetId);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_ADD_TO_TAG_OK.equals(status)) {
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
            Element tagsElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_TAGS);
            Element targetElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_TARGET);
            Element targetIdElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_TARGET_ID);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(tagsElm);
            requestElm.add(targetElm);
            requestElm.add(targetIdElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_ADD_TO_TAG);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            targetElm.setText(target);
            targetIdElm.setText(targetId);
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
                baseBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_ADD_TO_MY_BOX_OK.equals(status)) {
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
