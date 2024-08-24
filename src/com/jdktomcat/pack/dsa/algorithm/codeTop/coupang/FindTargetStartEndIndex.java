package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class FindTargetStartEndIndex {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param numbers 目标数组
     * @param target  目标值
     * @return 目标元素的第一个和最后一个位置
     */
    public static int[] searchRange(int[] numbers, int target) {
        int[] range = {-1, -1};
        int left = 0, right = numbers.length - 1, index = -1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (numbers[mid] == target) {
                index = mid;
                break;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index != -1) {
            left = index;
            right = index;
            while (left > 0 && numbers[left - 1] == target) {
                left--;
            }
            while (right < numbers.length - 1 && numbers[right + 1] == target) {
                right++;
            }
            range[0] = left;
            range[1] = right;
        }
        return range;
    }

    public static void main(String[] args) {
        int[] numbers = {1};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(numbers, target)));
    }

}
