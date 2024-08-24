package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

public class RotateArraySearch {

    /**
     * 旋转数组查找目标数字（二分查找法）
     *
     * @param numbers 数组
     * @param target  目标数字
     * @return 结果索引
     */
    public static int search(int[] numbers, int target) {
        if (numbers.length == 0) {
            return -1;
        }
        if (numbers.length == 1) {
            return numbers[0] == target ? 0 : -1;
        }
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (numbers[mid] == target) {
                return mid;
            }
            if (numbers[0] <= numbers[mid]) {
                if (numbers[0] <= target && target < numbers[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
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
