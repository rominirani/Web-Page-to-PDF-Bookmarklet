/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import java.util.List;

/**
 * @author Jimmy
 * 
 */
public interface GetFriendsResponse extends BoxResponse {

    /**
     * @return the friendList
     */
    public List getFriendList();

    /**
     * @param friendList
     *            the friendList to set
     */
    public void setFriendList(List friendList);

    /**
     * @return the encodedFriends
     */
    public String getEncodedFriends();

    /**
     * @param encodedFriends
     *            the encodedFriends to set
     */
    public void setEncodedFriends(String encodedFriends);
}
