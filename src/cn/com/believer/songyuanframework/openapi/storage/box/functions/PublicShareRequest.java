/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * @author Jimmy
 * 
 */
public interface PublicShareRequest extends BoxRequest {

    /**
     * @return the authToken
     */
    public String getAuthToken();

    /**
     * @param authToken
     *            the authToken to set
     */
    public void setAuthToken(String authToken);

    /**
     * @return the target
     */
    public String getTarget();

    /**
     * @param target
     *            the target to set
     */
    public void setTarget(String target);

    /**
     * @return the targetId
     */
    public String getTargetId();

    /**
     * @param targetId
     *            the targetId to set
     */
    public void setTargetId(String targetId);

    /**
     * @return the password
     */
    public String getPassword();

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password);

    /**
     * @return the message
     */
    public String getMessage();

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message);

    /**
     * @return the emails
     */
    public String[] getEmails();

    /**
     * @param emails
     *            the emails to set
     */
    public void setEmails(String[] emails);
}
