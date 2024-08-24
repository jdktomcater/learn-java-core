package com.jdktomcat.pack.dsa.algorithm.redblacktree;

/**
 * 类描述：红黑树
 *
 * @author 汤旗
 * @date 2019-05-29 10:28
 */
public class RedBlackTree {
    /**
     * 根节点
     */
    private RedBlackNode root;

    public RedBlackTree(RedBlackNode root) {
        this.root = root;
    }

    public RedBlackNode getRoot() {
        return root;
    }

    public void setRoot(RedBlackNode root) {
        this.root = root;
    }


}
