/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import java.util.List;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.UploadResponse;

/**
 * @author Jimmy
 * 
 */
public class UploadResponseImpl extends BoxResponseImpl implements
        UploadResponse {

    /** a list of UploadResult object. */
    private List uploadResultList;

    /**
     * @return the uploadResultList
     */
    public List getUploadResultList() {
        return this.uploadResultList;
    }

    /**
     * @param uploadResultList
     *            the uploadResultList to set
     */
    public void setUploadResultList(List uploadResultList) {
        this.uploadResultList = uploadResultList;
    }
}
