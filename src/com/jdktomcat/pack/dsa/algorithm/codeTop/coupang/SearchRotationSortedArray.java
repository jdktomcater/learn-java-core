package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 搜索旋转排序数组
 */
public class SearchRotationSortedArray {

    /**
     * 搜索旋转排序数组
     *
     * @param numbers 数组
     * @param target  目标
     * @return 下标索引
     */
    public static int search(int[] numbers, int target) {
        // 左右指针
        int left = 0, right = numbers.length - 1;
        // 循环条件
        while (left < right) {
            // 中间点
            int mid = (right + left) >> 1;
            // 如果中间点与target一样的话，找到返回
            if (numbers[mid] == target) {
                return mid;
            }
            // 如果开始点小于中间值
            if (numbers[0] < numbers[mid]) {
                // 中间点在折点前 有序部分二分查找
                if (numbers[0] < target && target < numbers[mid]) {
                    // 右侧缩减
                    right = mid - 1;
                } else {
                    // 左侧增加 无序部分二分查找
                    left = mid + 1;
                }
            } else {
                // 中间点在折点后 有序部分二分查找
                if (numbers[mid] < target && target < numbers[numbers.length - 1]) {
                    // 左侧增加
                    left = mid + 1;
                } else {
                    // 右侧缩减 无序部分二分查找
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
