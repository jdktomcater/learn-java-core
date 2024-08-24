package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p97;

/**
 * 子序列数目
 */
public class SubSequenceCount {

    /**
     * 子序列数目计算
     *
     * @param s 目标字符串
     * @param t 子序列
     * @return 子序列数目
     */
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1][0] = 1;
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String s = "appplep";
        String t = "apple";
        System.out.println(numDistinct(s, t));
    }
}
