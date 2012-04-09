/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFolder;

/**
 * @author Jimmy
 * 
 */
public interface CreateFolderResponse extends BoxResponse {

    /**
     * @return the folder
     */
    public BoxFolder getFolder();

    /**
     * @param folder
     *            the folder to set
     */
    public void setFolder(BoxFolder folder);
}
