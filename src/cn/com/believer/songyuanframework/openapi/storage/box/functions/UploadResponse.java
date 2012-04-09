/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import java.util.List;

/**
 * @author Jimmy
 * 
 */
public interface UploadResponse extends BoxResponse {

    /**
     * the UploadResult list.
     * @return the uploadResultList
     */
    public List getUploadResultList();

    /**
     * @param uploadResultList
     *            the uploadResultList to set
     */
    public void setUploadResultList(List uploadResultList);
}
