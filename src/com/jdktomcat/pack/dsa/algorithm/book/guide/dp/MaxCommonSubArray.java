package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

/**
 * 最长公共子串
 */
public class MaxCommonSubArray {

    /**
     * 最长公共子串长度
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最长公共子串长度
     */
    public static int maxCommonLength(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }



}
