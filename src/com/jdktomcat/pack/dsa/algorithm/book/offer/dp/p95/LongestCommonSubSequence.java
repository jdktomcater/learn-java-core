package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p95;

/**
 * 最长公共子序列长度
 */
public class LongestCommonSubSequence {

    /**
     * 计算两个字符串公共子序列长度
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 长度
     */
    public static int longestCommonSubSequenceL2(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * 计算两个字符串公共子序列长度
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 长度
     */
    public static int longestCommonSubSequenceL1(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 < len2) {
            return longestCommonSubSequenceL1(s2, s1);
        }
        int[][] dp = new int[2][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1;
                } else {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[(i + 1) % 2][j], dp[i % 2][j + 1]);
                }
            }
        }
        return dp[len1 % 2][len2];
    }

    /**
     * 计算两个字符串公共子序列长度
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 长度
     */
    public static int longestCommonSubSequenceL0(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 < len2) {
            return longestCommonSubSequenceL1(s2, s1);
        }
        int[] dp = new int[len2 + 1];
        for (int i = 0; i < len1; i++) {
            int prev = dp[0];
            for (int j = 0; j < len2; j++) {
                int cur;
                if (s1.charAt(i) == s2.charAt(j)) {
                    cur = prev + 1;
                } else {
                    cur = Math.max(dp[j], dp[j + 1]);
                }
                prev = dp[j + 1];
                dp[j + 1] = cur;
            }
        }
        return dp[len2];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "badfe";
        System.out.println(longestCommonSubSequenceL2(s1, s2));
        System.out.println(longestCommonSubSequenceL1(s1, s2));
        System.out.println(longestCommonSubSequenceL0(s1, s2));
    }
}
