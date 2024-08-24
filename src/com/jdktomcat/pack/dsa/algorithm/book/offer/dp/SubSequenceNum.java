package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;


/**
 * 子序列数目
 */
public class SubSequenceNum {
    /**
     * 计算子序列数目
     *
     * @param target 目标字符串
     * @param sub    子串
     * @return 数目
     */
    public static int numDistinct(String target, String sub) {
        int[][] dp = new int[target.length() + 1][sub.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i < target.length(); i++) {
            dp[i + 1][0] = 1;
            for (int j = 0; j <= i && j < sub.length(); j++) {
                if (target.charAt(i) == sub.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[target.length()][sub.length()];
    }

    /**
     * 计算子序列数目
     *
     * @param target 目标字符串
     * @param sub    子串
     * @return 数目
     */
    public static int numDistinctAdvance(String target, String sub) {
        int[] dp = new int[sub.length() + 1];
        if (target.length() > 0) {
            dp[0] = 1;
        }
        for (int i = 0; i < target.length(); i++) {
            for (int j = Math.min(i, sub.length() - 1); j >= 0; j--) {
                if (target.charAt(i) == sub.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[sub.length()];
    }


    public static void main(String[] args) {
        String target = "appplep";
        String sub = "apple";
        System.out.println(numDistinctAdvance(target, sub));
    }
}
