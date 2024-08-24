package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p47;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 二叉树剪枝
 */
public class PruneTree {

    /**
     * 二叉树剪枝
     *
     * @param root 根节点
     * @return 处理后树根节点
     */
    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
