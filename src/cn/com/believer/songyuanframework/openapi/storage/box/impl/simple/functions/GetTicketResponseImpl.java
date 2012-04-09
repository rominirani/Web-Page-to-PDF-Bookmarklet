/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketResponse;

/**
 * @author Jimmy
 * 
 */
public class GetTicketResponseImpl extends BoxResponseImpl implements
        GetTicketResponse {

    /** ticket. */
    private String ticket;

    /**
     * @return the ticket
     */
    public String getTicket() {
        return this.ticket;
    }

    /**
     * @param ticket
     *            the ticket to set
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
