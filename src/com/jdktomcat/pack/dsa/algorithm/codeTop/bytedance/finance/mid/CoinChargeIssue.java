package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class CoinChargeIssue {

    /**
     * 换零钱
     *
     * @param coins  零钱数组
     * @param amount 总和
     * @return 最少币种
     */
    public static int coinChange(int[] coins, int amount) {
        int[] min = {Integer.MAX_VALUE};
        dfs(coins, 0, amount, min);
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }

    /**
     * 深度计算逻辑
     *
     * @param coins  币种信息
     * @param count  币数量
     * @param amount 总和
     * @param min    最小
     */
    private static void dfs(int[] coins, int count, int amount, int[] min) {
        if (amount == 0) {
            min[0] = Math.min(count, min[0]);
        } else if (amount > 0) {
            for (int coin : coins) {
                dfs(coins, count + 1, amount - coin, min);
            }
        }
    }

    /**
     * 换零钱
     *
     * @param coins  零钱数组
     * @param amount 总和
     * @return 最少币种
     */
    public static int coinChangeL0(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 组合数
     *
     * @param amount 金额
     * @param coins  币种数组
     * @return 组合数
     */
    public static int change(int[] coins, int amount) {
        // 动态规划
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i + coin <= amount; i++) {
                dp[i + coin] += dp[i];
            }
        }
        return dp[amount];
    }

    /**
     * 组合数
     *
     * @param amount 金额
     * @param coins  币种数组
     * @return 组合数
     */
    public static int changeL0(int[] coins, int amount) {
        int[] count = {0};
        dfsL0(coins, amount, count);
        return count[0];
    }

    /**
     * 深度计算逻辑
     *
     * @param coins  币种信息
     * @param amount 总和
     * @param count  最小
     */
    private static void dfsL0(int[] coins, int amount, int[] count) {
        if (amount == 0) {
            count[0]++;
        } else if (amount > 0) {
            for (int coin : coins) {
                dfsL0(coins, amount - coin, count);
            }
        }
    }


    public static void main(String[] args) {
        int[] coins = {1,2,3,4,5};
        int amount = 11;
        System.out.println(change(coins, amount));
    }
}
