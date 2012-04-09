/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicShareRequest;

/**
 * @author Jimmy
 * 
 */
public class PublicShareRequestImpl extends BoxRequestImpl implements
        PublicShareRequest {

    /** auth token. */
    private String authToken;

    /** target, could be 'file' or 'folder'. */
    private String target;

    /** target id, file id or folder id. */
    private String targetId;

    /** password to protect the shared file or folder. */
    private String password;

    /** message to send these emails. */
    private String message;

    /** email array. */
    private String[] emails;

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
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_PUBLIC_SHARE;
    }

}
