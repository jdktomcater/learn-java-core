package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 寻找峰值
 */
public class PeakNumber {

    /**
     * 寻找峰值索引（二分法）
     *
     * @param numbers 数组
     * @return 峰值索引
     */
    public static int findPeakElement(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] < numbers[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
