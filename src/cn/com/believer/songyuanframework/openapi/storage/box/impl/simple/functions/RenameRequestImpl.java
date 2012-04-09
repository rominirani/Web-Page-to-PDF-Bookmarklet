/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RenameRequest;

/**
 * @author Jimmy
 * 
 */
public class RenameRequestImpl extends BoxRequestImpl implements RenameRequest {

    /** auth token. */
    private String authToken;

    /** target, could be 'file' or 'folder'. */
    private String target;

    /** target id, file id or folder id. */
    private String targetId;

    /** new file or folder name. */
    private String newName;

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
     * @return the newName
     */
    public String getNewName() {
        return this.newName;
    }

    /**
     * @param newName
     *            the newName to set
     */
    public void setNewName(String newName) {
        this.newName = newName;
    }

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_RENAME;
    }
}
