/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.objects;

import java.util.List;

/**
 * @author Jimmy
 * 
 */
public interface BoxFriend {

    /**
     * @return the name
     */
    public String getName();

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name);

    /**
     * @return the email
     */
    public String getEmail();

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email);

    /**
     * @return the accepted
     */
    public String getAccepted();

    /**
     * @param accepted
     *            the accepted to set
     */
    public void setAccepted(String accepted);

    /**
     * @return the avatarUrl
     */
    public String getAvatarUrl();

    /**
     * @param avatarUrl
     *            the avatarUrl to set
     */
    public void setAvatarUrl(String avatarUrl);

    /**
     * @return the boxes
     */
    public List getBoxes();

    /**
     * @param boxes
     *            the boxes to set
     */
    public void setBoxes(List boxes);

    /**
     * @return the subscriptions
     */
    public List getSubscriptions();

    /**
     * @param subscriptions
     *            the subscriptions to set
     */
    public void setSubscriptions(List subscriptions);
}
