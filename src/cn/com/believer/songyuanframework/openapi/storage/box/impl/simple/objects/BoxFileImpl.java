/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.objects;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;

/**
 * @author Jimmy
 * 
 */
public class BoxFileImpl implements BoxFile {

    /** file id. */
    private String fileId;

    /** file name. */
    private String fileName;

    /** folder id. */
    private String folderId;

    /** shared flag. */
    private boolean shared;

    /** shared name. */
    private String sharedName;

    /** file size. */
    private long size;

    /** file description. */
    private String description;

    /** sha1 value, used to verify file content. */
    private String sha1;

    /** created time. */
    private long created;

    /** updated time. */
    private long updated;

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
     * @return the fileName
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * @param fileName
     *            the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
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
     * @return the shared
     */
    public boolean isShared() {
        return this.shared;
    }

    /**
     * @param shared
     *            the shared to set
     */
    public void setShared(boolean shared) {
        this.shared = shared;
    }

    /**
     * @return the sharedName
     */
    public String getSharedName() {
        return this.sharedName;
    }

    /**
     * @param sharedName
     *            the sharedName to set
     */
    public void setSharedName(String sharedName) {
        this.sharedName = sharedName;
    }

    /**
     * @return the size
     */
    public long getSize() {
        return this.size;
    }

    /**
     * @param size
     *            the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the sha1
     */
    public String getSha1() {
        return this.sha1;
    }

    /**
     * @param sha1
     *            the sha1 to set
     */
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    /**
     * @return the created
     */
    public long getCreated() {
        return this.created;
    }

    /**
     * @param created
     *            the created to set
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * @return the updated
     */
    public long getUpdated() {
        return this.updated;
    }

    /**
     * @param updated
     *            the updated to set
     */
    public void setUpdated(long updated) {
        this.updated = updated;
    }
}
