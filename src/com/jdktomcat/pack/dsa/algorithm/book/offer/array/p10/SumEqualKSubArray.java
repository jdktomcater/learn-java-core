package com.jdktomcat.pack.dsa.algorithm.book.offer.array.p10;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的子数组
 */
public class SumEqualKSubArray {

    /**
     * 和为k的子数组个数
     *
     * @param numbers 数组
     * @param k       目标数组
     * @return 和为k的子数组个数
     */
    public static int subArraySum(int[] numbers, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : numbers) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 10;
        System.out.println(subArraySum(numbers, target));
    }
}
