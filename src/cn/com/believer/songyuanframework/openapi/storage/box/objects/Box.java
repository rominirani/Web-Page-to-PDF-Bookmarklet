/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.objects;

/**
 * @author Jimmy
 * 
 */
public interface Box {

    /**
     * get the box id.
     * 
     * @return the id
     */
    public String getId();

    /**
     * set the box id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(String id);

    /**
     * get box URL.
     * 
     * @return the url
     */
    public String getUrl();

    /**
     * set box URL.
     * 
     * @param url
     *            the url to set
     */
    public void setUrl(String url);

    /**
     * get box status.
     * 
     * @return the status
     */
    public String getStatus();

    /**
     * set box status.
     * 
     * @param status
     *            the status to set
     */
    public void setStatus(String status);
}
