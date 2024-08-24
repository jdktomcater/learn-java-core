package com.jdktomcat.interview.xhs;

public class UncrossedLines {
    /**
     * 最大不相交连接线数量(相当于两数组最长公共子序列问题)
     * 动态规划：
     * 状态转移方程：
     * dp[i][j]={
     *     1、nums1[i-1]=nums2[j-1]
     *        dp[i][j] = dp[i-1][j-1] + 1;
     *     2、nums[i-1]!=nums2[j-1]
     *        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
     * }
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 最大连接线数量
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
