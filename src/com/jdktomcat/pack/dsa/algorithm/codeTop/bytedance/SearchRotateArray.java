package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 搜索旋转排序数组
 */
public class SearchRotateArray {

    /**
     * 搜索旋转排序数组目标值下标 二分法查找
     *
     * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
     * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 目标值下标
     */
    public static int searchRotateArray(int[] numbers, int target) {
        // 判断是否有元素
        if (numbers.length == 0) {
            return -1;
        }
        // 判断是否只有一个元素
        if (numbers.length == 1) {
            return numbers[0] == target ? 0 : -1;
        }
        // 左右指针
        int left = 0, right = numbers.length - 1;
        // 循环判断条件
        while (left <= right) {
            // 中间索引
            int mid = (right + left) / 2;
            // 如果中间索引对应值等于目标值，返回索引
            if (numbers[mid] == target) {
                return mid;
            }
            // 如果中间值大于开始值
            if (numbers[0] <= numbers[mid]) {
                // 目标值在0到mid之间
                if (numbers[0] <= target && target < numbers[mid]) {
                    right = mid - 1;
                // mid+1 -- end
                } else {
                    left = mid + 1;
                }
            } else {
                // 目标值在mid到end之间
                if (numbers[mid] < target && target <= numbers[numbers.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
