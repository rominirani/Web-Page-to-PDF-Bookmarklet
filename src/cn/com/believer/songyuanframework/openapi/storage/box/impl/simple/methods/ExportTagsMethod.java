/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.methods;

import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.ExportTagsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.ExportTagsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.utils.ConverterUtils;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class ExportTagsMethod extends BaseBoxMethod {

    /**
     * This method returns all the user's tags.
     * 
     * On successful a result, you will receive 'export_tags_ok' and tag_xml
     * will be base64 encoded tags xml. After decoding tag_xml you will get xml
     * like this:
     * 
     * <?xml version="1.0"?> <tags> <tag id="37"> music </tag> <tag id="38"> mp3
     * </tag> </tags> If the result wasn't successful, status field can be:
     * not_logged_id, application_restricted.
     * 
     * @param exportTagsRequest
     *            request
     * @return response
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    public ExportTagsResponse exportTags(ExportTagsRequest exportTagsRequest)
            throws IOException, BoxException {
        ExportTagsResponse exportTagsResponse = BoxResponseFactory
                .createExportTagsResponse();

        String apiKey = exportTagsRequest.getApiKey();
        String authToken = exportTagsRequest.getAuthToken();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_EXPORT_TAGS);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(authToken);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                exportTagsResponse.setStatus(status);
                if (BoxConstant.STATUS_EXPORT_TAGS_OK.equals(status)) {
                    Element tagsXMLElm = responseElm
                            .element(BoxConstant.PARAM_NAME_TAGS);
                    List tagsList = ConverterUtils
                            .transferTags2List(tagsXMLElm);
                    exportTagsResponse.setTagList(tagsList);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(exportTagsResponse.getStatus());
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
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_EXPORT_TAGS);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());

            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                exportTagsResponse.setStatus(status);
                if (BoxConstant.STATUS_EXPORT_TAGS_OK.equals(status)) {
                    Element tagsXMLElm = responseElm
                            .element(BoxConstant.PARAM_NAME_TAGS);
                    List tagsList = ConverterUtils
                            .transferTags2List(tagsXMLElm);
                    exportTagsResponse.setTagList(tagsList);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException(
                        "failed to parse to a document.", e);
                be.setStatus(exportTagsResponse.getStatus());
                throw be;
            }
        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP
                .equals(apiRequestFormat)) {

        } else {
        }
        return exportTagsResponse;
    }
}
