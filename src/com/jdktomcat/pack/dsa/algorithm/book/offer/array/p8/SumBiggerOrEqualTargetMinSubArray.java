package com.jdktomcat.pack.dsa.algorithm.book.offer.array.p8;

/**
 * 和大于或等于k的最短子数组
 */
public class SumBiggerOrEqualTargetMinSubArray {

    /**
     * 和大于或等于k的最短子数组长度
     *
     * @param numbers 数组
     * @param k       目标值
     * @return 和大于或等于k的最短子数组长度
     */
    public static int minSuArrayLen(int[] numbers, int k) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < numbers.length; right++) {
            sum += numbers[right];
            while (left <= right && sum > k) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= numbers[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
