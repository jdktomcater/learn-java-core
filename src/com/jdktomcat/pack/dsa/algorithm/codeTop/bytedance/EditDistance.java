package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 编辑距离
 */
public class EditDistance {

    /**
     * 编辑最少距离
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 最少距离
     */
    public static int minDistanceL1(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }
        // DP 数组
        int[][] dp = new int[n + 1][m + 1];
        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }
        return dp[n][m];
    }

    /**
     * 编辑距离最小距离
     *
     * 那么我们可以写出如下的状态转移方程：
     *
     * 若 A 和 B 的最后一个字母相同：
     *
     * \begin{aligned} D[i][j] &= \min(D[i][j - 1] + 1, D[i - 1][j]+1, D[i - 1][j - 1])\\ &= 1 + \min(D[i][j - 1], D[i - 1][j], D[i - 1][j - 1] - 1) \end{aligned}
     * D[i][j]
     * ​
     *
     * =min(D[i][j−1]+1,D[i−1][j]+1,D[i−1][j−1])
     * =1+min(D[i][j−1],D[i−1][j],D[i−1][j−1]−1)
     * ​
     *
     * 若 A 和 B 的最后一个字母不同：
     *
     * D[i][j] = 1 + \min(D[i][j - 1], D[i - 1][j], D[i - 1][j - 1])
     * D[i][j]=1+min(D[i][j−1],D[i−1][j],D[i−1][j−1])
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 编辑距离最小距离
     */
    public static int minDistanceL0(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        // 第一列
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        // 计算逻辑
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 判断字符是否相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 取三者（插入、删除、更新）最小值加一操作
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistanceL0(word1, word2));
    }
}
