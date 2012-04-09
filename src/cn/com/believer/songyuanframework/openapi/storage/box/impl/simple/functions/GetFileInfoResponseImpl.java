/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;

/**
 * @author Jimmy
 * 
 */
public class GetFileInfoResponseImpl extends BoxResponseImpl implements
        GetFileInfoResponse {

    /** box file. */
    private BoxFile file;

    /**
     * @return the file
     */
    public BoxFile getFile() {
        return this.file;
    }

    /**
     * @param file
     *            the file to set
     */
    public void setFile(BoxFile file) {
        this.file = file;
    }
}
