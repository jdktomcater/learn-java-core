package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

/**
 * 最长公共子序列
 */
public class MaxCommonSeq {

    /**
     * 最长公共子序列长度缓存
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最长公共子序列缓存
     */
    private static int[][] maxDp(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp;
    }

    /**
     * 最长公共子序列长度
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最长公共子序列长度
     */
    public static int maxCommonLength(String str1, String str2) {
        int[][] dp = maxDp(str1, str2);
        return dp[str1.length()][str2.length()];
    }

    /**
     * 最长公共子序列
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最长公共子序列
     */
    public static String maxCommonSeq(String str1, String str2) {
        int[][] dp = maxDp(str1, str2);
        int m = str1.length();
        int n = str2.length();
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = str1.charAt(m - 1);
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA456B6A";
        System.out.println(maxCommonSeq(str1, str2));
    }

}
