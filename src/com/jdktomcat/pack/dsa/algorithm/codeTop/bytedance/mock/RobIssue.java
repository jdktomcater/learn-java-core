package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.mock;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

public class RobIssue {

    /**
     * 动态规划
     *
     * @param root 树根
     * @return 最大收益
     */
    public static int rob3(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    /**
     * 深度遍历计算（后序遍历）
     *
     * @param node 节点
     * @return 选中、不选中值（0：选中 1：不选中）
     */
    public static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        // 选择根节点，不能选择子节点
        int selected = node.val + l[1] + r[1];
        // 不选根节点，取最大值
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }

    public static int rob1(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int[] dp = new int[numbers.length + 1];
        dp[0] = 0;
        dp[1] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + numbers[i], dp[i]);
        }
        return dp[numbers.length];
    }

    public static int rob2(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        if (numbers.length == 2) {
            return Math.max(numbers[0], numbers[1]);
        }
        return Math.max(rob2(numbers, 0, numbers.length - 2), rob2(numbers, 1, numbers.length - 1));
    }

    /**
     * 抢劫范围内最大值
     *
     * @param numbers 数组
     * @param start   开始索引
     * @param end     截止索引
     * @return 最大值
     */
    private static int rob2(int[] numbers, int start, int end) {
        if (end - start == 1) {
            return Math.max(numbers[start], numbers[end]);
        }
        int[] dp = new int[end - start + 2];
        dp[0] = 0;
        dp[1] = numbers[start];
        for (int i = 1; i < end - start + 1; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + numbers[start + i], dp[i]);
        }
        return dp[end - start + 1];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob2(nums));
    }


}
