/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketRequest;

/**
 * @author Jimmy
 * 
 */
public class GetTicketRequestImpl extends BoxRequestImpl implements
        GetTicketRequest {

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_GET_TICKET;
    }

}
