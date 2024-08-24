package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 爬楼梯
 */
public class ClimbStairs {

    /**
     * 爬楼梯 (递归)
     *
     * @param n 楼梯
     * @return 爬法
     */
    public static int climbStairs(int n) {
        int[] result = {0};
        dfs(n, result);
        return result[0];
    }

    private static void dfs(int n, int[] result) {
        if (n == 0) {
            result[0]++;
        } else if (n > 0) {
            dfs(n - 1, result);
            dfs(n - 2, result);
        }
    }

    /**
     * 爬楼梯 (动态规划)
     *
     * @param n 楼梯
     * @return 爬法
     */
    public static int climbStairsL0(int n) {
        int p, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 爬楼梯 (动态规划)
     *
     * @param n 楼梯
     * @return 爬法
     */
    public static int climbStairsL1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(climbStairsL1(10));
    }
}
