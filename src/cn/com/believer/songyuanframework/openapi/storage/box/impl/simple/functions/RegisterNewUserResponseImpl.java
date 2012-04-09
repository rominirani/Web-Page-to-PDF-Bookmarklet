/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.RegisterNewUserResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxUser;

/**
 * @author Jimmy
 * 
 */
public class RegisterNewUserResponseImpl extends BoxResponseImpl implements
        RegisterNewUserResponse {

    /** auth token. */
    private String authToken;

    /** returned user object. */
    private BoxUser user;

    /**
     * @return the authToken
     */
    public String getAuthToken() {
        return this.authToken;
    }

    /**
     * @param authToken the authToken to set
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * @return the user
     */
    public BoxUser getUser() {
        return this.user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(BoxUser user) {
        this.user = user;
    }
}
