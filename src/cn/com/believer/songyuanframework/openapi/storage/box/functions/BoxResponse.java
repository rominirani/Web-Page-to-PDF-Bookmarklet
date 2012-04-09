/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * This is the super interface for all box response, you can set and get a
 * status string from this response.
 * 
 * @author jjia
 * 
 */
public interface BoxResponse {

    /**
     * get the status string.
     * 
     * @return the status
     */
    String getStatus();

    /**
     * set the status string.
     * 
     * @param status
     *            the status to set
     */
    void setStatus(String status);
}
