package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

/**
 * 不相交的线
 */
public class MaxUncrossedLines {
    /**
     * 不相交的线（最长公共子序列）
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 最大线
     */
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
