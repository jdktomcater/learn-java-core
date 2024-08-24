package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

/**
 * 最长递增子序列
 */
public class LongestOfLis {

    /**
     * 最长递增子序列
     *
     * @param nums 数组
     * @return 长度
     */
    public static int lengthOfLIS(int[] nums) {
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

    public static void main(String[] args) {
        int[] numbers = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(numbers));
    }
}
