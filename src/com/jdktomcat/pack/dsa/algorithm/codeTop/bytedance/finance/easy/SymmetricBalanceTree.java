package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 对称二叉树
 */
public class SymmetricBalanceTree {

    /**
     * 是否是对称二叉树
     *
     * @param root 树根节点
     * @return true:是 false:否
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isLeftRightSymmetric(root.left, root.right);
    }

    /**
     * 判断左右是否对称
     *
     * @param leftNode  左节点
     * @param rightNode 右节点
     * @return true：是 false：否
     */
    private static boolean isLeftRightSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode != null && rightNode != null && leftNode.val == rightNode.val) {
            return isLeftRightSymmetric(leftNode.left, rightNode.right) && isLeftRightSymmetric(leftNode.right, rightNode.left);
        }
        return leftNode == null && rightNode == null;
    }
}
