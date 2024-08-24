package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.*;

/**
 * 缺失的区间
 */
public class FindMissingRanges {
    /**
     * 查找缺失的区间(暴力)
     *
     * @param numbers 数组
     * @param lower   上限
     * @param upper   下限
     * @return 缺失的区间列表
     */
    public static List<String> findMissingRanges(int[] numbers, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }
        int left = 0, right = 0;
        boolean flag = false;
        for (int i = lower; i <= upper; i++) {
            if (!set.contains(i)) {
                if (!flag) {
                    flag = true;
                    left = i;
                }
            } else {
                if (flag) {
                    if (left == i - 1) {
                        ranges.add("" + left);
                    } else {
                        ranges.add("" + left + "->" + (i - 1));
                    }
                }
                flag = false;
                left = i;
            }
            right = i;
        }
        if (flag) {
            if (left == right) {
                ranges.add("" + left);
            } else {
                ranges.add("" + left + "->" + right);
            }
        }
        return ranges;
    }

    /**
     * 查找缺失的区间(二分法)
     *
     * @param numbers 数组
     * @param lower   上限
     * @param upper   下限
     * @return 缺失的区间列表
     */
    public static List<String> findMissingRangesL0(int[] numbers, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        int left = lower;
        for (int number : numbers) {
            if (number > left) {
                if (number == left + 1) {
                    ranges.add("" + left);
                } else {
                    ranges.add("" + left + "->" + (number - 1));
                }
            }
            left = number + 1;
        }
        if (numbers.length == 0 || upper > numbers[numbers.length - 1]) {
            if (upper == left) {
                ranges.add("" + left);
            } else {
                ranges.add("" + left + "->" + upper);
            }
        }
        return ranges;
    }

    public static void main(String[] args) {
        int[] numbers = {};
        int lower = 1, upper = 1;
        System.out.println(Arrays.toString(findMissingRanges(numbers, lower, upper).toArray()));
    }

}
