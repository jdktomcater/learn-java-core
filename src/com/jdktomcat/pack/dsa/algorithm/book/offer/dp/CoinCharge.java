package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;

import java.util.Arrays;

/**
 * 最少硬币数目
 */
public class CoinCharge {

    /**
     * 换零钱
     *
     * @param coins  钱币数组
     * @param target 目标值
     * @return 最少换法
     */
    public static int coinCharge1(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = target; j >= 1; j--) {
                for (int k = 1; k * coin <= j; k++) {
                    dp[j] = Math.min(dp[j], dp[j - k * coin] + k);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }

    /**
     * 换零钱
     *
     * @param coins  钱币数组
     * @param target 目标值
     * @return 最少换法
     */
    public static int coinCharge2(int[] coins, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; ++i) {
            dp[i] = target + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 3, 9, 10};
        int target = 15;
        System.out.println(coinCharge1(coins, target));
        System.out.println(coinCharge2(coins, target));
    }

}
