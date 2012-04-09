/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import java.util.Map;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.UploadRequest;

/**
 * @author Jimmy
 * 
 */
public class UploadRequestImpl extends BoxRequestImpl implements UploadRequest {

    /** auth token. */
    private String authToken;

    /** folder id. */
    private String folderId;

    /** true means will upload Java File object rather than pure bytes array. */
    private boolean asFile;

    /**
     * map key is file name, value could be either Java File object or bytes
     * array.
     */
    private Map dataMap;

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
     * @return the asFile
     */
    public boolean isAsFile() {
        return this.asFile;
    }

    /**
     * @param asFile
     *            the asFile to set
     */
    public void setAsFile(boolean asFile) {
        this.asFile = asFile;
    }

    /**
     * @return the dataMap
     */
    public Map getDataMap() {
        return this.dataMap;
    }

    /**
     * @param dataMap
     *            the dataMap to set
     */
    public void setDataMap(Map dataMap) {
        this.dataMap = dataMap;
    }

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_UPLOAD;
    }
}
