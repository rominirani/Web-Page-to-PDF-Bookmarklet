/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.objects;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.UploadResult;

/**
 * @author Jimmy
 * 
 */
public class UploadResultImpl implements UploadResult {

    /** the box file object. */
    private BoxFile file;

    /** error information, if any. */
    private String errorInfo;

    /** true if any error occured. */
    private boolean hasError;

    /**
     * @return the file
     */
    public BoxFile getFile() {
        return this.file;
    }

    /**
     * @param file
     *            the file to set
     */
    public void setFile(BoxFile file) {
        this.file = file;
    }

    /**
     * @return the errorInfo
     */
    public String getErrorInfo() {
        return this.errorInfo;
    }

    /**
     * @param errorInfo
     *            the errorInfo to set
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    /**
     * @return the hasError
     */
    public boolean isHasError() {
        return this.hasError;
    }

    /**
     * @param hasError
     *            the hasError to set
     */
    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
}
