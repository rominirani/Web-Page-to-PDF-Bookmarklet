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
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxObjectFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxUser;

/**
 * @author Jimmy
 * 
 */
public class GetAuthTokenMethod extends BaseBoxMethod {

    /**
     * 
     */
    public GetAuthTokenMethod() {
        super();
    }

    /**
     * 
     * @param getAuthTokenRequest
     *            request
     * @return response
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    public GetAuthTokenResponse getAuthToken(
            GetAuthTokenRequest getAuthTokenRequest) throws IOException,
            BoxException {
        GetAuthTokenResponse getAuthTokenResponse = BoxResponseFactory
                .createGetAuthTokenResponse();

        String apiKey = getAuthTokenRequest.getApiKey();
        String ticket = getAuthTokenRequest.getTicket();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_GET_AUTH_TOKEN);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_TICKET);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(ticket);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                getAuthTokenResponse.setStatus(status);
                if (BoxConstant.STATUS_GET_AUTH_TOKEN_OK.equals(status)) {
                    Element authTokenElm = responseElm
                            .element(BoxConstant.PARAM_NAME_AUTH_TOKEN);
                    Element userElm = responseElm
                            .element(BoxConstant.PARAM_NAME_USER);
                    String authToken = authTokenElm.getText();

                    Element loginElm = userElm
                            .element(BoxConstant.PARAM_NAME_LOGIN);
                    Element emailElm = userElm
                            .element(BoxConstant.PARAM_NAME_EMAIL);
                    Element accessIdElm = userElm
                            .element(BoxConstant.PARAM_NAME_ACCESS_ID);
                    Element userIdElm = userElm
                            .element(BoxConstant.PARAM_NAME_USER_ID);
                    Element spaceAmountElm = userElm
                            .element(BoxConstant.PARAM_NAME_SPACE_AMOUNT);
                    Element spaceUsedElm = userElm
                            .element(BoxConstant.PARAM_NAME_SPACE_USED);
                    // \\
                    getAuthTokenResponse.setAuthToken(authToken);
                    BoxUser user = BoxObjectFactory.createBoxUser();
                    user.setLogin(loginElm.getText());
                    user.setEmail(emailElm.getText());
                    user.setAccessId(accessIdElm.getText());
                    user.setUserId(userIdElm.getText());
                    long spaceAmount = 0;
                    try {
                        spaceAmount = Long.parseLong(spaceAmountElm.getText());
                    } catch (NumberFormatException e) {
                        spaceAmount = Long.MIN_VALUE;
                    }
                    user.setSpaceAmount(spaceAmount);
                    long spaceUsed = 0;
                    try {
                        spaceUsed = Long.parseLong(spaceUsedElm.getText());
                    } catch (NumberFormatException e) {
                        spaceUsed = Long.MIN_VALUE;
                    }
                    user.setSpaceUsed(spaceUsed);
                    getAuthTokenResponse.setUser(user);
                }
            } catch (DocumentException e) {
                throw new BoxException("failed to parse to a document.", e);
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
            Element ticketElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_TICKET);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(ticketElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_GET_AUTH_TOKEN);
            apiKeyElm.setText(apiKey);
            ticketElm.setText(ticket);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                getAuthTokenResponse.setStatus(status);
                if (BoxConstant.STATUS_GET_AUTH_TOKEN_OK.equals(status)) {
                    Element authTokenElm = responseElm
                            .element(BoxConstant.PARAM_NAME_AUTH_TOKEN);
                    Element userElm = responseElm
                            .element(BoxConstant.PARAM_NAME_USER);
                    String authToken = authTokenElm.getText();

                    Element loginElm = userElm
                            .element(BoxConstant.PARAM_NAME_LOGIN);
                    Element emailElm = userElm
                            .element(BoxConstant.PARAM_NAME_EMAIL);
                    Element accessIdElm = userElm
                            .element(BoxConstant.PARAM_NAME_ACCESS_ID);
                    Element userIdElm = userElm
                            .element(BoxConstant.PARAM_NAME_USER_ID);
                    Element spaceAmountElm = userElm
                            .element(BoxConstant.PARAM_NAME_SPACE_AMOUNT);
                    Element spaceUsedElm = userElm
                            .element(BoxConstant.PARAM_NAME_SPACE_USED);
                    // \\
                    getAuthTokenResponse.setAuthToken(authToken);
                    BoxUser user = BoxObjectFactory.createBoxUser();
                    user.setLogin(loginElm.getText());
                    user.setEmail(emailElm.getText());
                    user.setAccessId(accessIdElm.getText());
                    user.setUserId(userIdElm.getText());
                    long spaceAmount = 0;
                    try {
                        spaceAmount = Long.parseLong(spaceAmountElm.getText());
                    } catch (NumberFormatException e) {
                        spaceAmount = Long.MIN_VALUE;
                    }
                    user.setSpaceAmount(spaceAmount);
                    long spaceUsed = 0;
                    try {
                        spaceUsed = Long.parseLong(spaceUsedElm.getText());
                    } catch (NumberFormatException e) {
                        spaceUsed = Long.MIN_VALUE;
                    }
                    user.setSpaceUsed(spaceUsed);
                    getAuthTokenResponse.setUser(user);
                }
            } catch (DocumentException e) {
                throw new BoxException("failed to parse to a document.", e);
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP
                .equals(apiRequestFormat)) {

        } else {
        }
        return getAuthTokenResponse;

    }
}
