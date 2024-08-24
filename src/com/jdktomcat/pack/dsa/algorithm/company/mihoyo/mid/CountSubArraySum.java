package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 */
public class CountSubArraySum {
    /**
     * 和为K的子数组个数
     *
     * @param numbers 数组
     * @param k       目标和
     * @return 子数组个数
     */
    public static int subArraySum(int[] numbers, int k) {
        int[][] sumDp = new int[numbers.length][numbers.length];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumDp[i][i] = numbers[i];
            if (sumDp[i][i] == k) {
                count++;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                sumDp[i][j] = sumDp[i][j - 1] + numbers[j];
                if (sumDp[i][j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 和为K的子数组个数（前缀和+哈希表）
     *
     * @param numbers 数组
     * @param k       目标和
     * @return 子数组个数
     */
    public static int subArraySumL0(int[] numbers, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int number : numbers) {
            pre += number;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1};
        int k = 2;
        System.out.println(subArraySum(numbers, k));
    }
}
