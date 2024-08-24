package com.jdktomcat.pack.dsa.algorithm.company.bytedance;

import java.util.Arrays;

/**
 * 类描述：动态规划换零钱
 *
 * @author 汤旗
 * @date 2019-10-11 21:01
 */
public class MakeCharge {

    /**
     * 最大面额
     */
    private static int max_unit = 0;

    /**
     * 换零钱方式数最少钱数
     *
     * @param target 目标值
     * @param units  单位
     * @return 换零钱方式数
     */
    private static int minUnit(int target, int[] units) {
        if (target == 0) {
            return 0;
        }
        int best = -1;
        for (int unit : units) {
            if (unit <= target) {
                int nextTry = minUnit(target - unit, units);
                if (nextTry >= 0 && (best < 0 || best > nextTry + 1)) {
                    best = nextTry + 1;
                }
            }
        }
        return best;
    }

    /**
     * 换钱
     *
     * @param target 目标
     * @param units  面值数组
     * @return 方式
     */
    public static int charge(int target, int[] units, int startIndex) {
        if (target == 0) {
            return 1;
        }
        int total = 0;
        for (int index = startIndex; index < units.length; index++) {
            int unit = units[index];
            if (unit <= target) {
                total += charge(target - unit, units, index);
            } else {
                break;
            }
        }
        return total;
    }

    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return charge(amount, coins, 0);
    }

    public static int changeNew(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        // 设置起始状态
        dp[0] = 1;
        for (int coin : coins) {
            // 记录每添加一种面额的零钱，总金额j的变化
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    // 在上一钟零钱状态的基础上增大
                    // 例如对于总额5，当只有面额为1的零钱时，只有一种可能 5x1
                    // 当加了面额为2的零钱时，除了原来的那一种可能外
                    // 还加上了组合了两块钱的情况，而总额为5是在总额为3的基础上加上两块钱来的
                    // 所以就加上此时总额为3的所有组合情况
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

    public static int changeNew1(int amount, int[] coins) {
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

    public static void main(String[] args) {
        int[] units = {1, 99};
        int total = 100;
        System.out.println(String.format("target:%d  total:%d", total, changeNew1(total, units)));
    }
}
