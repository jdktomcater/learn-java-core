package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.hard;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 二叉树中的最大路径和
 */
public class MaxBtNodePath {

    /**
     * 最大路径和
     *
     * @param root 树根节点
     * @return 最大路径和
     */
    public static int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }

    /**
     * 深度计算节点
     *
     * @param root 树根节点
     * @param max  最大值
     * @return 节点和
     */
    private static int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int[] leftMax = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.left, leftMax));
        int[] rightMax = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.right, rightMax));
        max[0] = Math.max(Math.max(leftMax[0], rightMax[0]), left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
