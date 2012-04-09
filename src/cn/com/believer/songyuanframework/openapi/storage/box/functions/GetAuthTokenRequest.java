/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * @author Jimmy
 * 
 */
public interface GetAuthTokenRequest extends BoxRequest {

    /**
     * @return the ticket
     */
    public String getTicket();

    /**
     * @param ticket
     *            the ticket to set
     */
    public void setTicket(String ticket);
}
