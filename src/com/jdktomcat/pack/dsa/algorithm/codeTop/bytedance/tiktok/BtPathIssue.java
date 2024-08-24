package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.tiktok;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 二叉树路径相关问题
 */
public class BtPathIssue {

    public static int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }

    private static int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int[] lefMax = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.left, lefMax));
        int[] rightMax = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.right, rightMax));
        max[0] = Math.max(lefMax[0], rightMax[0]);
        max[0] = Math.max(max[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }

}
