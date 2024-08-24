package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;


/**
 * 两个字符串最长子序列长度
 */
public class LongestCommonSubSequence {

    /**
     * 计算最长共同子序列长度
     *
     * @param target1 目标字符串1
     * @param target2 目标字符串2
     * @return 最长长度
     */
    public static int cal(String target1, String target2) {
        int len1 = target1.length();
        int len2 = target2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (target1.charAt(i) == target2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String target1 = "adcde";
        String target2 = "badfe";
        System.out.println(cal(target1, target2));
    }
}
