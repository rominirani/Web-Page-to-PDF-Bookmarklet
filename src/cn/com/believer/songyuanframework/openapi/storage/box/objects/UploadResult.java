/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.objects;


/**
 * @author Jimmy
 * 
 */
public interface UploadResult {

    /**
     * @return the file
     */
    public BoxFile getFile();

    /**
     * @param file
     *            the file to set
     */
    public void setFile(BoxFile file);

    /**
     * @return the errorInfo
     */
    public String getErrorInfo();

    /**
     * @param errorInfo
     *            the errorInfo to set
     */
    public void setErrorInfo(String errorInfo);

    /**
     * @return the hasError
     */
    public boolean isHasError();

    /**
     * @param hasError
     *            the hasError to set
     */
    public void setHasError(boolean hasError);
}
