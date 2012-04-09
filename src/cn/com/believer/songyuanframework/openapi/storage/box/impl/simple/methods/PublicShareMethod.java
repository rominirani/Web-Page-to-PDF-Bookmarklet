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
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicShareRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicShareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class PublicShareMethod extends BaseBoxMethod {

    /**
     * This method publicly shares a file or folder. 'target' param should be
     * either 'file' or 'folder', 'target_id' is id of the file or folder to be
     * shared. 'password' param is to protect sharing with a password, 'emails'
     * params is array of emails to notify about a new share, 'message' param is
     * some message to be included in a notification email.
     * 
     * On a successful result, the status will be 'share_ok' and 'public_name'
     * param will be a unique identifier of a publicly shared file or folder. If
     * the result wasn't successful, the status field can be: 'share_error',
     * 'wrong_node', 'not_logged_in', 'application_restricted'.
     * 
     * @param publicShareRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public PublicShareResponse publicShare(PublicShareRequest publicShareRequest)
            throws IOException, BoxException {
        PublicShareResponse publicShareResponse = BoxResponseFactory
                .createPublicShareResponse();

        String apiKey = publicShareRequest.getApiKey();
        String authToken = publicShareRequest.getAuthToken();
        String message = publicShareRequest.getMessage();
        String target = publicShareRequest.getTarget();
        String targetId = publicShareRequest.getTargetId();
        String password = publicShareRequest.getPassword();
        String[] emails = publicShareRequest.getEmails();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {

            URLCodec codec = new URLCodec();
            message = codec.encode(message, "ISO-8859-1");
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_PUBLIC_SHARE);
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
            urlBuff.append(BoxConstant.PARAM_NAME_PASSWORD);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(password);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_MESSAGE);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(message);
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
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                publicShareResponse.setStatus(status);
                if (BoxConstant.STATUS_SHARE_OK.equals(status)) {
                    Element publicNameElm = responseElm
                            .element(BoxConstant.PARAM_NAME_PUBLIC_NAME);
                    String publicName = publicNameElm.getText();
                    publicShareResponse.setPublicName(publicName);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(publicShareResponse.getStatus());
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
            Element passwordElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_PASSWORD);
            Element messageElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_MESSAGE);
            Element emailsElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_EMAILS);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(targetElm);
            requestElm.add(targetIdElm);
            requestElm.add(passwordElm);
            requestElm.add(messageElm);
            requestElm.add(emailsElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_PUBLIC_SHARE);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            targetElm.setText(target);
            targetIdElm.setText(targetId);
            passwordElm.setText(password);
            messageElm.setText(message);
            if (emails != null) {
                for (int i = 0; i < emails.length; i++) {
                    String email = emails[i];
                    Element emailElm = DocumentHelper
                            .createElement(BoxConstant.PARAM_NAME_ITEM);
                    emailElm.setText(email);
                    emailsElm.add(emailElm);
                }
            }
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                publicShareResponse.setStatus(status);
                if (BoxConstant.STATUS_SHARE_OK.equals(status)) {
                    Element publicNameElm = responseElm
                            .element(BoxConstant.PARAM_NAME_PUBLIC_NAME);
                    String publicName = publicNameElm.getText();
                    publicShareResponse.setPublicName(publicName);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(publicShareResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP
                .equals(apiRequestFormat)) {

        } else {
        }
        return publicShareResponse;

    }
}
