package com.jdktomcat.pack.dsa.algorithm.codeTop.amazon.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 二叉树的直径
 */
public class BtMaxDiameter {
    /**
     * 二叉树的直径
     *
     * @param root 树根节点
     * @return 二叉树最大直径
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] max = {0};
        travel(root, max);
        return max[0];
    }

    /**
     * 中序遍历
     *
     * @param root 树根节点
     * @param max  最大直径
     */
    private static void travel(TreeNode root, int[] max) {
        if (root != null) {
            int maxLeft = maxDept(root.left);
            int maxRight = maxDept(root.right);
            max[0] = Math.max(max[0], maxLeft + maxRight);
            travel(root.left, max);
            travel(root.right, max);
        }
    }

    /**
     * 最大深度
     *
     * @param root 树根节点
     * @return 最大深度
     */
    private static int maxDept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDept(root.left), maxDept(root.right)) + 1;
    }

    /**
     * 二叉树的直径
     *
     * @param root 树根节点
     * @return 二叉树的直径
     */
    public static int diameterOfBinaryTreeL0(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfsDi(root, maxSum);
        return maxSum[0] - 1;
    }

    /**
     * 深度遍历
     *
     * @param root   根节点
     * @param maxSum 最大数组
     * @return 和
     */
    private static int dfsDi(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int[] maxSumLeft = {Integer.MIN_VALUE};
        int left = Math.max(0, dfsDi(root.left, maxSumLeft));
        int[] maxSumRight = {Integer.MIN_VALUE};
        int right = Math.max(0, dfsDi(root.right, maxSumRight));
        maxSum[0] = Math.max(maxSumLeft[0], maxSumRight[0]);
        maxSum[0] = Math.max(maxSum[0], 1 + left + right);
        return 1 + Math.max(left, right);
    }

}
