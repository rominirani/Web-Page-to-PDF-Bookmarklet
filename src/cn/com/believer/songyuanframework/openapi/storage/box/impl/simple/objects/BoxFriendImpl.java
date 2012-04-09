/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.objects;

import java.util.List;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFriend;

/**
 * @author Jimmy
 * 
 */
public class BoxFriendImpl implements BoxFriend {

    /** friend's name. */
    private String name;

    /** friend's email. */
    private String email;

    /** accepted. */
    private String accepted;

    /** avatar URL. */
    private String avatarUrl;

    /** friend's boxes, a list of Box object. */
    private List boxes;

    /** friends's subscriptions, a list of BoxSubscription object. */
    private List subscriptions;

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the accepted
     */
    public String getAccepted() {
        return this.accepted;
    }

    /**
     * @param accepted
     *            the accepted to set
     */
    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    /**
     * @return the avatarUrl
     */
    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    /**
     * @param avatarUrl
     *            the avatarUrl to set
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * @return the boxes
     */
    public List getBoxes() {
        return this.boxes;
    }

    /**
     * @param boxes
     *            the boxes to set
     */
    public void setBoxes(List boxes) {
        this.boxes = boxes;
    }

    /**
     * @return the subscriptions
     */
    public List getSubscriptions() {
        return this.subscriptions;
    }

    /**
     * @param subscriptions
     *            the subscriptions to set
     */
    public void setSubscriptions(List subscriptions) {
        this.subscriptions = subscriptions;
    }
}
