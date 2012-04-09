/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import java.util.List;

/**
 * @author Jimmy
 * 
 */
public interface ExportTagsResponse extends BoxResponse {

    /**
     * @return the tagList
     */
    public List getTagList();

    /**
     * @param tagList
     *            the tagList to set
     */
    public void setTagList(List tagList);

    /**
     * @return the encodedTags
     */
    public String getEncodedTags();

    /**
     * @param encodedTags
     *            the encodedTags to set
     */
    public void setEncodedTags(String encodedTags);
}
