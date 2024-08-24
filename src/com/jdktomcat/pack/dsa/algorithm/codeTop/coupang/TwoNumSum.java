package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;


import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 
 * 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoNumSum {
    /**
     * 两数之和
     *
     * @param numbers 目标数组
     * @param target  目标和
     * @return 等于目标和的下标
     */
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
            if (dataMap.containsKey(target - numbers[index])) {
                return new int[]{index, dataMap.get(target - numbers[index])};
            }
            dataMap.put(numbers[index], index);
        }
        return new int[]{};
    }

    /**
     * 两数之和 II - 输入有序数组
     * <p>
     * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
     * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和
     * numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     * 你所设计的解决方案必须只使用常量级的额外空间。
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 符合索引
     */
    public static int[] twoSumL0(int[] numbers, int target) {
        int left = 1, right = numbers.length;
        while (left < right) {
            if (numbers[left - 1] + numbers[right - 1] == target) {
                return new int[]{left, right};
            } else if (numbers[left - 1] + numbers[right - 1] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
