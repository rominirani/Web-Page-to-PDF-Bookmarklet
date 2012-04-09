/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.objects;

import java.util.List;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxAbstractFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxTag;

/**
 * @author Jimmy
 * 
 */
public class BoxAbstractFileImpl implements BoxAbstractFile {

    /** file id or folder id. */
    private String id;

    /** file name or folder name. */
    private String name;

    /** keyword. */
    private String keyword;

    /** shared flag. */
    private boolean shared;

    /** size of file, folder is 0. */
    private long size;

    /** is it a file or folder. */
    private boolean isFolder;

    /** created time. */
    private long created;

    /** updated time. */
    private long updated;

    /** tags, BoxTag object list. */
    private List tags;

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return this.keyword;
    }

    /**
     * @param keyword
     *            the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the shared
     */
    public boolean isShared() {
        return this.shared;
    }

    /**
     * @param shared
     *            the shared to set
     */
    public void setShared(boolean shared) {
        this.shared = shared;
    }

    /**
     * @return the size
     */
    public long getSize() {
        return this.size;
    }

    /**
     * @param size
     *            the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @return the isFolder
     */
    public boolean isFolder() {
        return this.isFolder;
    }

    /**
     * @param isFolder
     *            the isFolder to set
     */
    public void setFolder(boolean isFolder) {
        this.isFolder = isFolder;
    }

    /**
     * @return the created
     */
    public long getCreated() {
        return this.created;
    }

    /**
     * @param created
     *            the created to set
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * @return the updated
     */
    public long getUpdated() {
        return this.updated;
    }

    /**
     * @param updated
     *            the updated to set
     */
    public void setUpdated(long updated) {
        this.updated = updated;
    }

    /**
     * @return the tags
     */
    public List getTags() {
        return this.tags;
    }

    /**
     * @param tags
     *            the tags to set
     */
    public void setTags(List tags) {
        this.tags = tags;
    }

    /**
     * @return string.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id=" + id + "  ");
        sb.append("name=" + name + "  ");
        sb.append("keyword=" + keyword + "  ");
        sb.append("shared=" + shared + "  ");
        sb.append("size=" + size + "  ");
        sb.append("isFolder=" + isFolder + "  ");
        sb.append("created=" + created + "  ");
        sb.append("updated=" + updated + "  ");
        for (int i = 0; i < tags.size(); i++) {
            BoxTag tag = (BoxTag) tags.get(i);
            sb.append("tag[" + i + "]=" + tag + "  ");
        }
        return sb.toString();
    }

    // public BoxFile toBoxFile() {
    // BoxFile boxFile = BoxObjectFactory.createBoxFile();
    // boxFile.setCreated(created);
    // boxFile.setDescription(null);
    // boxFile.setFileId(id);
    // boxFile.setFileName(name);
    // boxFile.set
    //        
    // return boxFile;
    // }

}
