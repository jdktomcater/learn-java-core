package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p69;

/**
 * 山峰数组的顶部
 */
public class MountainPeakPosition {

    /**
     * 山峰数组的顶部位置
     *
     * @param numbers 山峰数组
     * @return 顶部位置
     */
    public static int peak(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] >= numbers[mid - 1] && numbers[mid] >= numbers[mid + 1]) {
                return mid;
            }
            if (numbers[mid] > numbers[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 5, 4, 2};
        System.out.println(peak(numbers));
    }

}
