package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.hard;

/**
 * 编辑距离
 */
public class EditDistance {

    /**
     * 编辑最少距离（动态规划）
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 编辑最少距离
     */
    public static int minDistance(String word1, String word2) {
        // 动态计算缓存（编辑最少距离，dp[i][j]表示word1长度i编辑距离word2长度j）
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                // 状态转移方程
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
