/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * @author Jimmy
 * 
 */
public interface GetAccountTreeRequest extends BoxRequest {

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
     * @return the params
     */
    public String[] getParams();

    /**
     * @param params
     *            the params to set
     */
    public void setParams(String[] params);
}
