/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import java.io.File;

/**
 * @author Jimmy
 * 
 */
public interface DownloadResponse extends BoxResponse {

    /**
     * @return the asFile
     */
    public boolean isAsFile();

    /**
     * @param asFile
     *            the asFile to set
     */
    public void setAsFile(boolean asFile);

    /**
     * @return the rawData
     */
    public byte[] getRawData();

    /**
     * @param rawData
     *            the rawData to set
     */
    public void setRawData(byte[] rawData);

    /**
     * @return the outFile
     */
    public File getOutFile();

    /**
     * @param outFile
     *            the outFile to set
     */
    public void setOutFile(File outFile);
}
