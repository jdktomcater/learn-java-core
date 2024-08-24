package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

public class LengthOfLIS {

    /**
     * 最长上升子序列长度（动态规划）
     *
     * @param nums 数组
     * @return 最长上升子序列长度（动态规划）
     */
    public static int lengthOfLISL0(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 缓存最长长度
        int[] dp = new int[nums.length];
        // 边界值
        dp[0] = 1;
        int max = 1;
        // 双层循环
        for (int i = 1; i < nums.length; i++) {
            // 初始值
            dp[i] = 1;
            // 内循环
            for (int j = 0; j < i; j++) {
                // 当外层大于内层
                if (nums[i] > nums[j]) {
                    // 动态方程
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
