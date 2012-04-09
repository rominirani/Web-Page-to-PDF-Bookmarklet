/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import java.util.List;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.ExportTagsResponse;

/**
 * @author Jimmy
 * 
 */
public class ExportTagsResponseImpl extends BoxResponseImpl implements
        ExportTagsResponse {

    /** BoxTag object list. */
    private List tagList;

    /** base64 encoded string. */
    private String encodedTags;

    /**
     * @return the tagList
     */
    public List getTagList() {
        return this.tagList;
    }

    /**
     * @param tagList
     *            the tagList to set
     */
    public void setTagList(List tagList) {
        this.tagList = tagList;
    }

    /**
     * @return the encodedTags
     */
    public String getEncodedTags() {
        return this.encodedTags;
    }

    /**
     * @param encodedTags
     *            the encodedTags to set
     */
    public void setEncodedTags(String encodedTags) {
        this.encodedTags = encodedTags;
    }
}
