package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

/**
 * 机器人路径问题
 */
public class AndroidPathIssue {
    /**
     * 统计方法数（递归回溯暴力计算）
     *
     * @param n 点数
     * @param m 起始位置
     * @param k 步数
     * @param p 目标节点
     * @return 方法数
     */
    public static int count0(int n, int m, int k, int p) {
        int[] count = {0};
        dfs(n, m, k, p, count);
        return count[0];
    }

    /**
     * 深度计算逻辑
     *
     * @param n     边界
     * @param m     起始位置
     * @param k     步数
     * @param p     位置
     * @param count 统计
     */
    private static void dfs(int n, int m, int k, int p, int[] count) {
        if (m == p && k == 0) {
            count[0]++;
        } else if (k > 0) {
            int next = getNext(n, m);
            if (next != -1) {
                dfs(n, next, k - 1, p, count);
            }
            int before = getBefore(m);
            if (before != -1) {
                dfs(n, before, k - 1, p, count);
            }
        }
    }

    /**
     * 获取下一个位置
     *
     * @param max 最大
     * @param n   位置
     * @return 下一个位置
     */
    private static int getNext(int max, int n) {
        if (n < max) {
            return n + 1;
        }
        return -1;
    }

    /**
     * 获取上一个位置
     *
     * @param n 位置
     * @return 上一个位置
     */
    private static int getBefore(int n) {
        if (n > 1) {
            return n - 1;
        }
        return -1;
    }

    /**
     * 机器人移动
     *
     * @param n 边界
     * @param m 目前位置
     * @param k 步数
     * @param p 目标位置
     * @return 移动步数
     */
    public static int walk(int n, int m, int k, int p) {
        if (k == 0) {
            return m == p ? 1 : 0;
        }
        if (m == 1) {
            return walk(n, 2, k - 1, p);
        }
        if (m == n) {
            return walk(n, n - 1, k - 1, p);
        }
        return walk(n, m + 1, k - 1, p) + walk(n, m - 1, k - 1, p);
    }

    /**
     * 统计方法数（递归回溯暴力计算）
     *
     * @param n 点数
     * @param m 起始位置
     * @param k 步数
     * @param p 目标节点
     * @return 方法数
     */
    public static int count1(int n, int m, int k, int p) {
        return walk(n, m, k, p);
    }

    /**
     * 统计方法数（动态规划）
     *
     * @param n 点数
     * @param m 起始位置
     * @param k 步数
     * @param p 目标节点
     * @return 方法数
     */
    public static int count3(int n, int m, int k, int p) {
        int[][] dp = new int[k + 1][n + 1];
        dp[0][p] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == n) {
                    dp[i][j] = dp[i - 1][n - 1];
                } else {
                    dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[k][m];
    }


    public static void main(String[] args) {
        int n = 5, m = 2, k = 3, p = 3;
        System.out.println(count1(n, m, k, p));
    }

}
