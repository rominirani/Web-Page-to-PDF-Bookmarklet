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
import cn.com.believer.songyuanframework.openapi.storage.box.functions.MoveRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.MoveResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class MoveMethod extends BaseBoxMethod {

    /**
     * This method moves a file or folder to another folder.
     * 
     * 'target' param can be either 'file' or 'folder' depending on what do you
     * want to move, 'target_id' is the id of a file or folder to be moved,
     * 'destination_id' is the destination folder id.
     * 
     * On a successful result, status will be 's_move_node'. If the result
     * wasn't successful, status field can be: 'e_move_node', 'not_logged_in',
     * 'application_restricted'.
     * 
     * @param moveRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public MoveResponse move(MoveRequest moveRequest) throws IOException,
            BoxException {
        MoveResponse baseBoxResponse = BoxResponseFactory.createMoveResponse();

        String apiKey = moveRequest.getApiKey();
        String authToken = moveRequest.getAuthToken();
        String target = moveRequest.getTarget();
        String targetId = moveRequest.getTargetId();
        String destinationId = moveRequest.getDestinationId();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_MOVE);
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
            urlBuff.append(BoxConstant.PARAM_NAME_DESTINATION_ID);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(destinationId);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_S_MOVE_NODE.equals(status)) {
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
            Element destinationIdElm = DocumentHelper
                    .createElement(BoxConstant.PARAM_NAME_DESTINATION_ID);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(targetElm);
            requestElm.add(targetIdElm);
            requestElm.add(destinationIdElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_MOVE);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            targetElm.setText(target);
            targetIdElm.setText(targetId);
            destinationIdElm.setText(destinationId);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
//                if (BoxConstant.STATUS_S_MOVE_NODE.equals(status)) {
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
