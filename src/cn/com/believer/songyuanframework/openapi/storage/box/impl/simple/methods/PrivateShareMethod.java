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
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PrivateShareRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PrivateShareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class PrivateShareMethod extends BaseBoxMethod {

    /**
     * This method privately shares a file or folder with another user(s).
     * 'target' param should be either 'file' or 'folder', 'target_id' is the id
     * of the file or folder to be shared. 'emails' params is an array of emails
     * of users' to share files with. if 'notify' param is true, then a
     * notification email will be sent to users, 'message' param is a message to
     * be included in the notification email.
     * 
     * Note: currently only files can be shared privately.
     * 
     * On a successful result, the status will be 'private_share_ok'. If the
     * result wasn't successful, the status field can be: 'private_share_error',
     * 'wrong_node', 'not_logged_in', 'application_restricted'.
     * 
     * @param privateShareRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public PrivateShareResponse privateShare(
            PrivateShareRequest privateShareRequest) throws IOException,
            BoxException {

        PrivateShareResponse baseBoxResponse = BoxResponseFactory
                .createPrivateShareResponse();

        String apiKey = privateShareRequest.getApiKey();
        String authToken = privateShareRequest.getAuthToken();
        String message = privateShareRequest.getMessage();
        String target = privateShareRequest.getTarget();
        String targetId = privateShareRequest.getTargetId();
        String[] emails = privateShareRequest.getEmails();
        boolean notify = privateShareRequest.isNofity();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {

            URLCodec codec = new URLCodec();
            message = codec.encode(message, "ISO-8859-1");
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_PRIVATE_SHARE);
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
            if (emails == null) {
                urlBuff.append(BoxConstant.AND_SIGN_STRING);
                urlBuff.append(BoxConstant.PARAM_NAME_PARAMS_EMAILS);
                urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            } else {
                for (int i = 0; i < emails.length; i++) {
                    String email = emails[i];
                    urlBuff.append(BoxConstant.AND_SIGN_STRING);
                    urlBuff.append(BoxConstant.PARAM_NAME_PARAMS_EMAILS);
                    urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
                    urlBuff.append(email);
                }
            }
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_MESSAGE);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(message);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_NOTIFY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(String.valueOf(notify));
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_PRIVATE_SHARE_OK.equals(status)) {
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
            Element emailsElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_EMAILS);
            Element messageElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_MESSAGE);
            Element notifyElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_NOTIFY);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(targetElm);
            requestElm.add(targetIdElm);
            requestElm.add(emailsElm);
            requestElm.add(messageElm);
            requestElm.add(notifyElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_PRIVATE_SHARE);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            targetElm.setText(target);
            targetIdElm.setText(targetId);
            if (emails != null) {
                for (int i = 0; i < emails.length; i++) {
                    String email = emails[i];
                    Element emailElm = DocumentHelper
                            .createElement(BoxConstant.PARAM_NAME_EMAIL);
                    emailElm.setText(email);
                    emailsElm.add(emailElm);
                }
            }
            messageElm.setText(message);
            notifyElm.setText(Boolean.toString(notify));
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_PRIVATE_SHARE_OK.equals(status)) {
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
