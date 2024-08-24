package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

/**
 * 搜索旋转排序数组
 */
public class SearchTargetFoldArray {

    /**
     * 搜索旋转排序数组
     *
     * @param numbers 数组
     * @param target  目标数字
     * @return 索引
     */
    public static int search(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (numbers[mid] == target) {
                return mid;
            }
            if (numbers[0] <= numbers[mid]) {
                if (numbers[0] <= target && numbers[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (numbers[mid] < target && numbers[numbers.length - 1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
