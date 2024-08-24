package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence {
    /**
     * 最长公共子序列 (动态规划)
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最长公共子序列长度
     */
    public int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
