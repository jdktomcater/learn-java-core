package com.jdktomcat.pack.dsa.algorithm.book.offer.array.p9;

/**
 * 乘积小于k的子数组
 */
public class ProductSmallerSubArray {

    /**
     * 乘积小于k的子数组个数
     *
     * @param numbers 数组
     * @param k       目标值
     * @return 子数组个数
     */
    public static int numSubArrayProductLessThanK(int[] numbers, int k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int right = 0; right < numbers.length; right++) {
            product *= numbers[right];
            while (left <= right && product >= k) {
                product /= numbers[left++];
            }
            count += right >= left ? right - left + 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 5, 2, 6};
        int target = 100;
        System.out.println(numSubArrayProductLessThanK(numbers, target));
    }

}
