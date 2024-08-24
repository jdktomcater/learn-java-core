package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;

/**
 * 数组分割
 */
public class NumsPartition {

    /**
     * 背包计算
     *
     * @param target 目标数组
     * @param dp     计算缓存
     * @param i      物品长度
     * @param j      背包容量
     * @return true：可以 false：不可以
     */
    private static boolean helper(int[] target, Boolean[][] dp, int i, int j) {
        if (dp[i][j] == null) {
            if (j == 0) {
                dp[i][j] = true;
            } else if (i == 0) {
                dp[i][j] = false;
            } else {
                dp[i][j] = helper(target, dp, i - 1, j);
                if (!dp[i][j] && j >= target[i - 1]) {
                    dp[i][j] = helper(target, dp, i - 1, j - target[i - 1]);
                }
            }
        }
        return dp[i][j];
    }

    /**
     * 背包计算
     *
     * @param target 目标数组
     * @param sum    背包容量
     * @return true：可以 false：不可以
     */
    private static boolean subsetSum(int[] target, int sum) {
        Boolean[][] dp = new Boolean[target.length + 1][sum + 1];
        return helper(target, dp, target.length, sum);
    }

    /**
     * 背包计算
     *
     * @param target 目标数组
     * @param sum    背包容量
     * @return true：可以 false：不可以
     */
    private static boolean subsetSumAdvance(int[] target, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= target.length; i++) {
            for (int j = sum; j > 0; --j) {
                if (!dp[j] && j >= target[i - 1]) {
                    dp[j] = dp[j - target[i - 1]];
                }
            }
        }
        return dp[sum];
    }

    /**
     * 判断数组是否可以分割成两个相等子数组
     *
     * @param target 目标数组
     * @return true：可以 false：不可以
     */
    public static boolean partition(int[] target) {
        int sum = 0;
        for (int num : target) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return subsetSumAdvance(target, sum / 2);
    }


    public static void main(String[] args) {
        int[] target1 = new int[]{3, 4, 1};
        int[] target2 = new int[]{1, 2, 3, 5};
        System.out.println(partition(target1));
        System.out.println(partition(target2));
    }
}
