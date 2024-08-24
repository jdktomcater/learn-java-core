package com.jdktomcat.pack.dsa.algorithm.book.offer.array.p11;

import java.util.HashMap;
import java.util.Map;

/**
 * 0和1个数相同的子数组
 */
public class ZeroOneLengthSameSubArray {

    /**
     * 0和1个数相同的子数组长度
     *
     * @param numbers 数组
     * @return 0和1个数相同的子数组长度
     */
    public static int findMaxLength(int[] numbers) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return maxLength;
    }

}
