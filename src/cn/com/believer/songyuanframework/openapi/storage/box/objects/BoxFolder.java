/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.objects;

/**
 * @author Jimmy
 * 
 */
public interface BoxFolder {

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
     * @return the folderName
     */
    public String getFolderName();

    /**
     * @param folderName
     *            the folderName to set
     */
    public void setFolderName(String folderName);

    /**
     * @return the folderTypeId
     */
    public String getFolderTypeId();

    /**
     * @param folderTypeId
     *            the folderTypeId to set
     */
    public void setFolderTypeId(String folderTypeId);

    /**
     * @return the userId
     */
    public String getUserId();

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId);

    /**
     * @return the path
     */
    public String getPath();

    /**
     * @param path
     *            the path to set
     */
    public void setPath(String path);

    /**
     * @return the shared
     */
    public String getShared();

    /**
     * @param shared
     *            the shared to set
     */
    public void setShared(String shared);

    /**
     * @return the publicName
     */
    public String getPublicName();

    /**
     * @param publicName
     *            the publicName to set
     */
    public void setPublicName(String publicName);

    /**
     * @return the showComments
     */
    public String getShowComments();

    /**
     * @param showComments
     *            the showComments to set
     */
    public void setShowComments(String showComments);

    /**
     * @return the parentFolderId
     */
    public String getParentFolderId();

    /**
     * @param parentFolderId
     *            the parentFolderId to set
     */
    public void setParentFolderId(String parentFolderId);

    /**
     * @return the password
     */
    public String getPassword();

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password);
}
