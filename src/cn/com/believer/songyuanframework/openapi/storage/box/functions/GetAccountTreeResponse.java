/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Jimmy
 * 
 */
public interface GetAccountTreeResponse extends BoxResponse {

    /**
     * @return the tree
     */
    public DefaultMutableTreeNode getTree();

    /**
     * @param tree
     *            the tree to set
     */
    public void setTree(DefaultMutableTreeNode tree);

    /**
     * @return the encodedTree
     */
    public String getEncodedTree();

    /**
     * @param encodedTree
     *            the encodedTree to set
     */
    public void setEncodedTree(String encodedTree);
}
