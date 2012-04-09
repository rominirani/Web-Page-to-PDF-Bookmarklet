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
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxObjectFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RegisterNewUserRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RegisterNewUserResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxUser;

/**
 * @author Jimmy
 * 
 */
public class RegisterNewUserMethod extends BaseBoxMethod {

    /**
     * This method is used to register a user. Upon a successful registration,
     * the status param will be 'successful_register'. If registration wasn't
     * successful, status field can be: 'e_register', 'email_invalid',
     * 'email_already_registered', 'application_restricted'.
     * 
     * @param registerNewUserRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public RegisterNewUserResponse registerNewUser(
            RegisterNewUserRequest registerNewUserRequest) throws IOException,
            BoxException {
        RegisterNewUserResponse registerNewUserResponse = BoxResponseFactory
                .createRegisterNewUserResponse();

        String apiKey = registerNewUserRequest.getApiKey();
        String loginName = registerNewUserRequest.getLoginName();
        String password = registerNewUserRequest.getPassword();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            URLCodec codec = new URLCodec();
            loginName = codec.encode(loginName, "ISO-8859-1");
            password = codec.encode(password, "ISO-8859-1");
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_REGISTER_NEW_USER);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_LOGIN);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(loginName);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_PASSWORD);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(password);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                registerNewUserResponse.setStatus(status);
                if (BoxConstant.STATUS_SUCCESSFUL_REGISTER.equals(status)) {
                    Element authTokenElm = responseElm
                            .element(BoxConstant.PARAM_NAME_AUTH_TOKEN);
                    Element userElm = responseElm
                            .element(BoxConstant.PARAM_NAME_USER);

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
                    //
                    String authToken = authTokenElm.getText();
                    registerNewUserResponse.setAuthToken(authToken);
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
                    registerNewUserResponse.setUser(user);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(registerNewUserResponse.getStatus());
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
            Element inLoginElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_LOGIN);
            Element passwordElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_PASSWORD);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(inLoginElm);
            requestElm.add(passwordElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_REGISTER_NEW_USER);
            apiKeyElm.setText(apiKey);
            inLoginElm.setText(loginName);
            passwordElm.setText(password);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                registerNewUserResponse.setStatus(status);
                if (BoxConstant.STATUS_SUCCESSFUL_REGISTER.equals(status)) {
                    Element authTokenElm = responseElm
                            .element(BoxConstant.PARAM_NAME_AUTH_TOKEN);
                    Element userElm = responseElm
                            .element(BoxConstant.PARAM_NAME_USER);

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
                    //
                    String authToken = authTokenElm.getText();
                    registerNewUserResponse.setAuthToken(authToken);
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
                    registerNewUserResponse.setUser(user);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(registerNewUserResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP
                .equals(apiRequestFormat)) {

        } else {
        }
        return registerNewUserResponse;

    }
}
