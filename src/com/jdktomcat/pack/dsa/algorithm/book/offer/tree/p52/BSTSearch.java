package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p52;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 二叉搜索树
 */
public class BSTSearch {

    /**
     * 二叉搜索树搜索原理逻辑
     *
     * @param root 树根节点
     * @param val  目标值
     * @return 节点
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                break;
            }
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }

}
