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
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class GetTicketMethod extends BaseBoxMethod {

    /**
     * 
     */
    public GetTicketMethod() {
        super();
    }

    /**
     * 
     * @param getTicketRequest
     *            request
     * @return response
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    public GetTicketResponse getTicket(GetTicketRequest getTicketRequest)
            throws IOException, BoxException {
        GetTicketResponse getTicketResponse = BoxResponseFactory
                .createGetTicketResponse();

        String apiKey = getTicketRequest.getApiKey();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super
                    .getRestUrl(BoxConstant.ACTION_NAME_GET_TICKET);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                getTicketResponse.setStatus(status);

                if (BoxConstant.STATUS_GET_TICKET_OK.equals(status)) {
                    Element ticketElm = responseElm
                            .element(BoxConstant.PARAM_NAME_TICKET);
                    String ticket = ticketElm.getText();
                    getTicketResponse.setTicket(ticket);
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
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_GET_TICKET);
            apiKeyElm.setText(apiKey);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                getTicketResponse.setStatus(status);

                if (BoxConstant.STATUS_GET_TICKET_OK.equals(status)) {
                    Element ticketElm = responseElm
                            .element(BoxConstant.PARAM_NAME_TICKET);
                    String ticket = ticketElm.getText();
                    getTicketResponse.setTicket(ticket);
                }
            } catch (DocumentException e) {
                throw new BoxException("failed to parse to a document.", e);
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP
                .equals(apiRequestFormat)) {
            Document document = getBaseSoapDocument();
            Element actionElm = getElementByActionName(BoxConstant.ACTION_NAME_GET_TICKET);
            Element bodyElm = document.getRootElement().element("soap:Body");
            bodyElm.add(actionElm);
            Element apiKeyElm = getSoapElement(BoxConstant.PARAM_NAME_API_KEY,
                    BoxConstant.SOAP_TYPE_STRING);
            actionElm.add(apiKeyElm);
            apiKeyElm.setText(apiKey);
            String result = httpManager.doPostXML(soapApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.elementByID("ns4:"
                        + BoxConstant.ACTION_NAME_GET_TICKET + "Response");
                Element statusElm = responseElm
                        .element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                getTicketResponse.setStatus(status);

                if (BoxConstant.STATUS_GET_TICKET_OK.equals(status)) {
                    Element ticketElm = responseElm
                            .element(BoxConstant.PARAM_NAME_TICKET);
                    String ticket = ticketElm.getText();
                    getTicketResponse.setTicket(ticket);
                }
            } catch (DocumentException e) {
                throw new BoxException("failed to parse to a document.", e);
            }
        } else {
            // unreachable code.
            System.gc();
        }
        return getTicketResponse;

    }
}
