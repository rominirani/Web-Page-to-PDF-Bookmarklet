/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.methods;

import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.core.BoxHTTPManager;

/**
 * @author Jimmy
 * 
 */
public class BaseBoxMethod {

    /** core http manager. */
    protected BoxHTTPManager httpManager = BoxHTTPManager.getBoxHTTPManager();

    /** the configuration. */
    protected Properties config = httpManager.getConfig();

    /** API URL prefix. */
    protected String apiUrlPrefix;

    /** API upload URL prefix. */
    protected String apiUploadUrlPrefix;

    /** API version. */
    protected String apiVersion;

    /** API request format. */
    protected String apiRequestFormat;

    /** API XML URL, it's static, so no need to read each time. */
    protected String xmlApiUrl;

    /** API SOAP URL, it's static, so no need to read each time. */
    protected String soapApiUrl;

    /**
     * 
     */
    public BaseBoxMethod() {
        this.apiUrlPrefix = config
                .getProperty(BoxConstant.CONFIG_API_URL_PREFIX);
        this.apiUploadUrlPrefix = config
                .getProperty(BoxConstant.CONFIG_API_UPLOAD_URL_PREFIX);
        this.apiVersion = config.getProperty(BoxConstant.CONFIG_API_VERSION);
        this.apiRequestFormat = config
                .getProperty(BoxConstant.CONFIG_API_REQUEST_FORMAT);

        this.xmlApiUrl = getXMLUrl();
        this.soapApiUrl = getSOAPUrl();
    }

    /**
     * according to action name, return a string buffer. i.e. "get_ticket" can
     * result a "http://www.box.net/api/1.0/rest?action=get_ticket"
     * 
     * @param actionName
     *            action name
     * @return the URL in string buffer
     */
    public StringBuffer getRestUrl(String actionName) {
        StringBuffer urlBuf = new StringBuffer();
        urlBuf.append(this.apiUrlPrefix);
        urlBuf.append(BoxConstant.SLASH_STRING);
        urlBuf.append(this.apiVersion);
        urlBuf.append(BoxConstant.SLASH_STRING);
        urlBuf.append(BoxConstant.CONFIG_API_REQUEST_FORMAT_REST);
        urlBuf.append(BoxConstant.QUESTION_MARK_STRING);
        urlBuf.append(BoxConstant.ACTION_EQUALS_STRING);
        urlBuf.append(actionName);
        return urlBuf;
    }

    /**
     * get the XML format URL. like: "http://www.box.net/api/1.0/xml"
     * 
     * @return URL string
     */
    private String getXMLUrl() {
        StringBuffer urlBuf = new StringBuffer();
        urlBuf.append(apiUrlPrefix);
        urlBuf.append(BoxConstant.SLASH_STRING);
        urlBuf.append(apiVersion);
        urlBuf.append(BoxConstant.SLASH_STRING);
        urlBuf.append(BoxConstant.CONFIG_API_REQUEST_FORMAT_XML);
        return urlBuf.toString();
    }

    /**
     * get the SOAP format URL. like: "http://box.net/api/1.0/soap"
     * 
     * @return URL string
     */
    private String getSOAPUrl() {
        StringBuffer urlBuf = new StringBuffer();
        urlBuf.append(apiUrlPrefix);
        urlBuf.append(BoxConstant.SLASH_STRING);
        urlBuf.append(apiVersion);
        urlBuf.append(BoxConstant.SLASH_STRING);
        urlBuf.append(BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP);
        return urlBuf.toString();
//        return "http://box.net/api/1.0/soap";
    }

    /**
     * get prepared document.
     * 
     * @return dom4j document
     */
    protected Document getBaseSoapDocument() {
        Document doc = DocumentHelper.createDocument();
        Element envelopeElm = DocumentHelper
                .createElement(BoxConstant.PARAM_NAME_SOAP_ENVELOPE);
        envelopeElm.addAttribute("xmlns:soap",
                "http://schemas.xmlsoap.org/soap/envelope/");
        envelopeElm.addAttribute("xmlns:soapenc",
                "http://schemas.xmlsoap.org/soap/encoding/");
        envelopeElm.addAttribute("xmlns:tns", "urn:boxnet");
        envelopeElm.addAttribute("xmlns:types", "urn:boxnet/encodedTypes");
        envelopeElm.addAttribute("xmlns:xsi",
                "http://www.w3.org/2001/XMLSchema-instance");
        envelopeElm.addAttribute("xmlns:xsd",
                "http://www.w3.org/2001/XMLSchema");
        doc.setRootElement(envelopeElm);
        Element bodyElm = DocumentHelper
                .createElement(BoxConstant.PARAM_NAME_SOAP_BODY);
        bodyElm.addAttribute("soap:encodingStyle",
                "http://schemas.xmlsoap.org/soap/encoding/");
        envelopeElm.add(bodyElm);
        return doc;
    }

    /**
     * 
     * @param actionName
     *            action name
     * @return element
     */
    protected Element getElementByActionName(String actionName) {
        Element elm = DocumentHelper.createElement("tns:" + actionName);
        return elm;
    }

    /**
     * 
     * @param elmName
     *            element name
     * @param elmType
     *            element type
     * @return element
     */
    protected Element getSoapElement(String elmName, String elmType) {
        Element elm = DocumentHelper.createElement(elmName);
        elm.addAttribute("xsi:type", elmType);
        return elm;
    }
}
