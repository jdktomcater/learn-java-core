package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p104;

/**
 * 排列的数目
 */
public class PermutationCount {

    /**
     * 排列的数目
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 排列的数目
     */
    public static int permutationSum(int[] numbers, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : numbers) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3};
        int target = 3;
        System.out.println(permutationSum(numbers, target));
    }

}
