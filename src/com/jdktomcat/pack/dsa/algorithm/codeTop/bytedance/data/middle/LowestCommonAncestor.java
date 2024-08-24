package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {

    /**
     * 最低公共祖先
     *
     * @param root 树根节点
     * @param p    节点1
     * @param q    节点2
     * @return 最低公共祖先节点
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 判断节点是否为空或者与节点相同，直接返回节点
        if (root == null || p == root || q == root) {
            return root;
        }
        // 左路径搜索
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右路径搜索
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 判断左节点及右节点及根节点
        return left == null ? right : (right == null ? left : root);
    }

}
