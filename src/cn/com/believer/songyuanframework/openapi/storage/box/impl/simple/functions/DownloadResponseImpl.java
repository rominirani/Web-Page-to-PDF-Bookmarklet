/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import java.io.File;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.DownloadResponse;

/**
 * @author Jimmy
 * 
 */
public class DownloadResponseImpl extends BoxResponseImpl implements
        DownloadResponse {

    /**
     * if true, will download as a File object, if false then download as bytes
     * array.
     */
    private boolean asFile;

    /** the raw data downloaded. */
    private byte[] rawData;

    /** the File object downloaded. */
    private File outFile;

    /**
     * @return the asFile
     */
    public boolean isAsFile() {
        return this.asFile;
    }

    /**
     * @param asFile
     *            the asFile to set
     */
    public void setAsFile(boolean asFile) {
        this.asFile = asFile;
    }

    /**
     * @return the rawData
     */
    public byte[] getRawData() {
        return this.rawData;
    }

    /**
     * @param rawData
     *            the rawData to set
     */
    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }

    /**
     * @return the outFile
     */
    public File getOutFile() {
        return this.outFile;
    }

    /**
     * @param outFile
     *            the outFile to set
     */
    public void setOutFile(File outFile) {
        this.outFile = outFile;
    }
}
