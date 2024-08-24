package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 二叉树中的最大路径和
 */
public class BtLongestPath {

    /**
     * 最大路径和
     *
     * @param root 树根节点
     * @return 最大路径和
     */
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }

    /**
     * 二叉树的直径
     *
     * @param root 树根节点
     * @return 二叉树的直径
     */
    public static int diameterOfBinaryTree(TreeNode root) {
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

    /**
     * 深度遍历
     *
     * @param root   根节点
     * @param maxSum 最大数组
     * @return 和
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


    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSumL0(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }


    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        TreeNode root = TreeNode.buildTree(numbers, 1);
        System.out.println(diameterOfBinaryTree(root));
    }
}
