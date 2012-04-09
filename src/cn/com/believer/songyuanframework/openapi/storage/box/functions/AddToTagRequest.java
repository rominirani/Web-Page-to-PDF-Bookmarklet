/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * @author Jimmy
 * 
 */
public interface AddToTagRequest extends BoxRequest {

    /**
     * @return the authToken
     */
    String getAuthToken();

    /**
     * @param authToken
     *            the authToken to set
     */
    void setAuthToken(String authToken);

    /**
     * @return the tags
     */
    String[] getTags();

    /**
     * @param tags
     *            the tags to set
     */
    void setTags(String[] tags);

    /**
     * @return the target
     */
    String getTarget();

    /**
     * @param target
     *            the target to set
     */
    void setTarget(String target);

    /**
     * @return the targetId
     */
    String getTargetId();

    /**
     * @param targetId
     *            the targetId to set
     */
    void setTargetId(String targetId);
}
