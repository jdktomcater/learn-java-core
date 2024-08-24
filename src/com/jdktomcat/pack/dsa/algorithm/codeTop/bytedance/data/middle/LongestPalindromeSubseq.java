package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

/**
 * 最长回文子序列
 */
public class LongestPalindromeSubseq {

    /**
     * 最长回文子序列长度（动态规划）
     *
     * @param s 目标字符串
     * @return 最长回文子序列长度
     */
    public static int longestPalindromeSubSeq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
