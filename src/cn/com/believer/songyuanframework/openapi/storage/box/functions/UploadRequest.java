/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import java.util.Map;

/**
 * @author Jimmy
 * 
 */
public interface UploadRequest extends BoxRequest {

    /**
     * @return the authToken
     */
    public String getAuthToken();

    /**
     * @param authToken
     *            the authToken to set
     */
    public void setAuthToken(String authToken);

    /**
     * @return the folderId
     */
    public String getFolderId();

    /**
     * @param folderId
     *            the folderId to set
     */
    public void setFolderId(String folderId);

    /**
     * @return the asFile
     */
    public boolean isAsFile();

    /**
     * @param asFile
     *            the asFile to set
     */
    public void setAsFile(boolean asFile);

    /**
     * @return the dataMap
     */
    public Map getDataMap();

    /**
     * @param dataMap
     *            the dataMap to set
     */
    public void setDataMap(Map dataMap);
}
