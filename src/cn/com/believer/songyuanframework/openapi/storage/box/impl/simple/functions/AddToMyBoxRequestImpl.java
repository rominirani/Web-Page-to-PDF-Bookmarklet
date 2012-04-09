/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToMyBoxRequest;

/**
 * @author jjia
 * 
 */
public class AddToMyBoxRequestImpl extends BoxRequestImpl implements
        AddToMyBoxRequest {

    /** auth token. */
    private String authToken;

    /** other user's public file id. */
    private String fileId;

    /** other user's shared file name. */
    private String publicName;

    /** current user's folder id. */
    private String folderId;

    /** tags on this item. */
    private String[] tags;

    /**
     * @return the authToken
     */
    public String getAuthToken() {
        return this.authToken;
    }

    /**
     * @param authToken
     *            the authToken to set
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * @return the fileId
     */
    public String getFileId() {
        return this.fileId;
    }

    /**
     * @param fileId
     *            the fileId to set
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     * @return the publicName
     */
    public String getPublicName() {
        return this.publicName;
    }

    /**
     * @param publicName
     *            the publicName to set
     */
    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    /**
     * @return the folderId
     */
    public String getFolderId() {
        return this.folderId;
    }

    /**
     * @param folderId
     *            the folderId to set
     */
    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    /**
     * @return the tags
     */
    public String[] getTags() {
        return this.tags;
    }

    /**
     * @param tags
     *            the tags to set
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_ADD_TO_MYBOX;
    }
}
