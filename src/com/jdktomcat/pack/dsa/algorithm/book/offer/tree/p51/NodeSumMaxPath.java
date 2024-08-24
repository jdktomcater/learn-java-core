package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p51;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 节点值之和最大的路径
 */
public class NodeSumMaxPath {

    /**
     * 节点值之和最大的路径
     *
     * @param root 根路径
     * @return 路径和
     */
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }

    /**
     * 深度遍历处理树节点
     *
     * @param root   树根节点
     * @param maxSum 最大值
     */
    private static int dfs(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int[] maxSumLeft = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.left, maxSumLeft));
        int[] maxSumRight = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.right, maxSumRight));
        maxSum[0] = Math.max(maxSumLeft[0], maxSumRight[0]);
        maxSum[0] = Math.max(maxSum[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{5, 2, 4, 1, 6, 3, 7};
        TreeNode root = TreeNode.buildTree(numbers, 1);
        System.out.println(maxPathSum(root));
    }

}
