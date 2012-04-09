/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * @author jjia
 * 
 */
public interface AddToMyBoxRequest {

    /**
     * @return the apiKey
     */
    String getApiKey();

    /**
     * @param apiKey
     *            the apiKey to set
     */
    void setApiKey(String apiKey);

    /**
     * @return the authToken
     */
    String getAuthToken();

    /**
     * @param authToken
     *            the authToken to set
     */
    void setAuthToken(String authToken);

    /**
     * @return the fileId
     */
    String getFileId();

    /**
     * @param fileId
     *            the fileId to set
     */
    void setFileId(String fileId);

    /**
     * @return the publicName
     */
    String getPublicName();

    /**
     * @param publicName
     *            the publicName to set
     */
    void setPublicName(String publicName);

    /**
     * @return the folderId
     */
    String getFolderId();

    /**
     * @param folderId
     *            the folderId to set
     */
    void setFolderId(String folderId);

    /**
     * @return the tags
     */
    String[] getTags();

    /**
     * @param tags
     *            the tags to set
     */
    void setTags(String[] tags);
}
