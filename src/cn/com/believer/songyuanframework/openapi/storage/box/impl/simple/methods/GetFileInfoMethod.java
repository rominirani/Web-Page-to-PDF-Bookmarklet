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
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.utils.ConverterUtils;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;

/**
 * @author Jimmy
 * 
 */
public class GetFileInfoMethod extends BaseBoxMethod {

    /**
     * This method gets file info. 'file_id' param should contain valid if of
     * user file.
     * 
     * On successful a result, you will receive status 's_get_file_info' and
     * file info in 'info'. If the result wasn't successful, status field can
     * be: e_access_denied.
     * 
     * @param getFileInfoRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public GetFileInfoResponse getFileInfo(GetFileInfoRequest getFileInfoRequest)
            throws IOException, BoxException {
        GetFileInfoResponse getFileInfoResponse = BoxResponseFactory
                .createGetFileInfoResponse();

        String apiKey = getFileInfoRequest.getApiKey();
        String authToken = getFileInfoRequest.getAuthToken();
        String fileId = getFileInfoRequest.getFileId();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_GET_FILE_INFO);
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
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                getFileInfoResponse.setStatus(status);
                if (BoxConstant.STATUS_S_GET_FILE_INFO.equals(status)) {
                    Element infoElm = responseElm
                            .element(BoxConstant.PARAM_NAME_INFO);
                    BoxFile soapFileInfo = ConverterUtils.toBoxFile(infoElm);
                    getFileInfoResponse.setFile(soapFileInfo);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(getFileInfoResponse.getStatus());
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
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(fileIdElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_GET_FILE_INFO);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            fileIdElm.setText(fileId);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                getFileInfoResponse.setStatus(status);
                if (BoxConstant.STATUS_S_GET_FILE_INFO.equals(status)) {
                    Element infoElm = responseElm
                            .element(BoxConstant.PARAM_NAME_INFO);
                    BoxFile soapFileInfo = ConverterUtils.toBoxFile(infoElm);
                    getFileInfoResponse.setFile(soapFileInfo);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(getFileInfoResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP
                .equals(apiRequestFormat)) {

        } else {
        }
        return getFileInfoResponse;
    }
}
