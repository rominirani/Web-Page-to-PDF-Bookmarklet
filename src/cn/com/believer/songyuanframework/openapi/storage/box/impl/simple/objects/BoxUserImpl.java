/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.objects;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxUser;

/**
 * @author Jimmy
 * 
 */
public class BoxUserImpl implements BoxUser {

    /** login account id. */
    private String login;

    /** email adress. */
    private String email;

    /** access id. */
    private String accessId;

    /** user id. */
    private String userId;

    /** space amount. */
    private long spaceAmount;

    /** space used. */
    private long spaceUsed;

    /**
     * @return the login
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the accessId
     */
    public String getAccessId() {
        return this.accessId;
    }

    /**
     * @param accessId
     *            the accessId to set
     */
    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the spaceAmount
     */
    public long getSpaceAmount() {
        return this.spaceAmount;
    }

    /**
     * @param spaceAmount the spaceAmount to set
     */
    public void setSpaceAmount(long spaceAmount) {
        this.spaceAmount = spaceAmount;
    }

    /**
     * @return the spaceUsed
     */
    public long getSpaceUsed() {
        return this.spaceUsed;
    }

    /**
     * @param spaceUsed the spaceUsed to set
     */
    public void setSpaceUsed(long spaceUsed) {
        this.spaceUsed = spaceUsed;
    }
}
