package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 翻转二叉树
 */
public class InvertBt {

    /**
     * 翻转二叉树
     *
     * @param root 树根节点
     * @return 翻转二叉树后根节点
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    /**
     * 深度遍历逻辑
     *
     * @param root 根节点
     */
    private static void dfs(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            dfs(root.left);
            dfs(root.right);
        }
    }

}
