package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

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
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }
}
