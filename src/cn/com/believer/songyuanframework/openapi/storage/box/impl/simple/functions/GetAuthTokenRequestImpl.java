/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenRequest;

/**
 * @author Jimmy
 * 
 */
public class GetAuthTokenRequestImpl extends BoxRequestImpl implements
        GetAuthTokenRequest {

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

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_GET_AUTH_TOKEN;
    }
}
