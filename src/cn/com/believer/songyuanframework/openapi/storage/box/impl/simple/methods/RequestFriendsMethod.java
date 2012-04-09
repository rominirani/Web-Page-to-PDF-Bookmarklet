/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.methods;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RequestFriendsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RequestFriendsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.utils.URLUtils;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class RequestFriendsMethod extends BaseBoxMethod {

    /**
     * This method requests new friends to be added to your network. 'emails' -
     * array of emails. 'message' - text message that you want to send to
     * freinds. 'params' is an array of string where you can set additional
     * parameters, which are: box_auto_subscribe - subscribe to public boxes of
     * inveted users. no_email - don't send emails to invited users.
     * 
     * On a successful result, you will receive status 's_request_friends'. If
     * the result wasn't successful, status field can be: e_request_friends.
     * 
     * @param requestFriendsRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public RequestFriendsResponse requestFriends(
            RequestFriendsRequest requestFriendsRequest) throws IOException,
            BoxException {
        RequestFriendsResponse baseBoxResponse = BoxResponseFactory
                .createRequestFriendsResponse();

        String apiKey = requestFriendsRequest.getApiKey();
        String authToken = requestFriendsRequest.getAuthToken();
        String message = requestFriendsRequest.getMessage();
        String[] emails = requestFriendsRequest.getEmails();
        String[] params = requestFriendsRequest.getParams();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            // encode to url namespace
            message = URLUtils.encodeUrl(message);
            for (int i = 0; i < emails.length; i++) {
                emails[i] = URLUtils.encodeUrl(emails[i]);
            }

            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_REQUEST_FRIENDS);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(authToken);
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
            if (params == null) {
                urlBuff.append(BoxConstant.AND_SIGN_STRING);
                urlBuff.append(BoxConstant.PARAM_NAME_PARAMS_PARAMS);
                urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            } else {
                for (int i = 0; i < params.length; i++) {
                    String param = params[i];
                    urlBuff.append(BoxConstant.AND_SIGN_STRING);
                    urlBuff.append(BoxConstant.PARAM_NAME_PARAMS_PARAMS);
                    urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
                    urlBuff.append(param);
                }
            }
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_S_REQUEST_FRIENDS.equals(status)) {
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
            Element emailsElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_EMAILS);
            Element messageElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_MESSAGE);
            Element paramsElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_PARAMS);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(emailsElm);
            requestElm.add(messageElm);
            requestElm.add(paramsElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_REQUEST_FRIENDS);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
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
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    String param = params[i];
                    Element paramElm = DocumentHelper
                            .createElement(BoxConstant.PARAM_NAME_ITEM);
                    paramElm.setText(param);
                    paramsElm.add(paramElm);
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
//                if (BoxConstant.STATUS_S_REQUEST_FRIENDS.equals(status)) {
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
