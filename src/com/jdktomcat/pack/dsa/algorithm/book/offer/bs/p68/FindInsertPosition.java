package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p68;

/**
 * 查询插入位置
 */
public class FindInsertPosition {

    /**
     * 查找要插入位置
     *
     * @param numbers 目标数组
     * @param target  目标值
     * @return 插入位置
     */
    public static int searchInsert(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] >= target) {
                if (mid == 0 || numbers[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return numbers.length;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,3,6,8};
        System.out.println(searchInsert(numbers,3));
        System.out.println(searchInsert(numbers,5));
        System.out.println(searchInsert(numbers,15));
    }
}
