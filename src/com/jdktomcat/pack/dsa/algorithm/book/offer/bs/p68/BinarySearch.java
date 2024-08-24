package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p68;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @param numbers 目标数组
     * @param target  目标
     * @return 索引（无的话 -1）
     */
    public static int search(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == target) {
                return mid;
            }
            if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
