/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import java.io.File;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DownloadRequest;

/**
 * @author Jimmy
 * 
 */
public class DownloadRequestImpl extends BoxRequestImpl implements
        DownloadRequest {

    /** auth token. */
    private String authToken;

    /** file id. */
    private String fileId;

    /**
     * if true, will download as a File object, if false then download as bytes
     * array.
     */
    private boolean asFile;

    /**
     * if asFile is true, this parameter will specify a File object which the
     * content will write in.
     */
    private File inFile;

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
     * @return the inFile
     */
    public File getInFile() {
        return this.inFile;
    }

    /**
     * @param inFile
     *            the inFile to set
     */
    public void setInFile(File inFile) {
        this.inFile = inFile;
    }

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_DOWNLOAD;
    }

}
