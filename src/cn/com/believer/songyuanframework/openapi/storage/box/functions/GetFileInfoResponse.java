/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;

/**
 * @author Jimmy
 * 
 */
public interface GetFileInfoResponse extends BoxResponse {

    /**
     * @return the file
     */
    public BoxFile getFile();

    /**
     * @param file
     *            the file to set
     */
    public void setFile(BoxFile file);
}
