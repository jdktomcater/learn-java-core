package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.hard;

/**
 * 编辑距离
 */
public class EditDistance {

    /**
     * 最小编辑距离
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 最小编辑距离
     */
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
