package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 最长递增子序列
 */
public class MaxIncreaseSubSeq {

    /**
     * 最长递增子序列长度（动态规划 O(n)）
     *
     * @param numbers 最长递增子序列长度
     * @return 最长递增子序列长度
     */
    public static int getMaxSeqLength(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int[] dp = maxSeqDp0(numbers);
        OptionalInt optionalInt = Arrays.stream(dp).max();
        return optionalInt.isPresent() ? optionalInt.getAsInt() : 0;
    }

    /**
     * 最长递增子序列长度（动态规划 O(n^2)）
     *
     * @param numbers 最长递增子序列长度
     * @return 最长递增子序列长度
     */
    public static int[] maxSeqDp0(int[] numbers) {
        int[] dp = new int[numbers.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    /**
     * 最长递增子序列长度（动态规划 O(n)）
     *
     * @param numbers 最长递增子序列长度
     * @return 最长递增子序列长度
     */
    public static int[] maxSeqDp1(int[] numbers) {
        int[] dp = new int[numbers.length];
        int[] ends = new int[numbers.length];
        ends[0] = numbers[0];
        dp[0] = 1;
        int right = 0;
        for (int i = 1; i < numbers.length; i++) {
            int l = 0;
            int r = right;
            while (l <= r) {
                int m = (r + l) >> 1;
                if (numbers[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = numbers[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    /**
     * 最大增长子序列
     *
     * @param numbers 数组
     * @param dp      缓存
     * @return 最大增长子序列
     */
    public static int[] generateLis(int[] numbers, int[] dp) {
        int len = 0, index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] seq = new int[len];
        seq[--len] = numbers[index];
        for (int i = index; i >= 0; i--) {
            if (numbers[i] < numbers[index] && dp[i] == dp[index] - 1) {
                seq[--len] = numbers[i];
                index = i;
            }
        }
        return seq;
    }


    public static void main(String[] args) {
        int[] numbers = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(Arrays.toString(generateLis(numbers, maxSeqDp0(numbers))));
    }
}
