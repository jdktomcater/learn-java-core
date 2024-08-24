package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.hard;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 最少监控二叉树摄像头
 */
public class MinCameraCover {

    /**
     * 最少监控二叉树摄像头
     *
     * @param root 树根节点
     * @return 最少监控二叉树摄像头
     */
    public static int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    /**
     * 深度计算逻辑
     *
     * @param root 树根节点
     * @return 需要
     */
    public static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }
}
