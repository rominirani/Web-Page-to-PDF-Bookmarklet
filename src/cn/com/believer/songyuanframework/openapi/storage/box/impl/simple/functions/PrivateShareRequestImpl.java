/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PrivateShareRequest;

/**
 * @author Jimmy
 * 
 */
public class PrivateShareRequestImpl extends BoxRequestImpl implements
        PrivateShareRequest {

    /** auth token. */
    private String authToken;

    /** target, could be 'file' or 'folder'. */
    private String target;

    /** target id, could be file id or folder id. */
    private String targetId;

    /** email array. */
    private String[] emails;

    /** message you want to send to these emails. */
    private String message;

    /** true means send email. */
    private boolean nofity;

    /**
     * @return the authToken
     */
    public String getAuthToken() {
        return this.authToken;
    }

    /**
     * @param authToken
     *            the authToken to set
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * @return the target
     */
    public String getTarget() {
        return this.target;
    }

    /**
     * @param target
     *            the target to set
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * @return the targetId
     */
    public String getTargetId() {
        return this.targetId;
    }

    /**
     * @param targetId
     *            the targetId to set
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    /**
     * @return the emails
     */
    public String[] getEmails() {
        return this.emails;
    }

    /**
     * @param emails
     *            the emails to set
     */
    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the nofity
     */
    public boolean isNofity() {
        return this.nofity;
    }

    /**
     * @param nofity
     *            the nofity to set
     */
    public void setNofity(boolean nofity) {
        this.nofity = nofity;
    }

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_PRIVATE_SHARE;
    }
}
