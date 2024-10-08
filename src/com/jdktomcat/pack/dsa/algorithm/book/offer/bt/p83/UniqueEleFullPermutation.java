package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p83;

import java.util.LinkedList;
import java.util.List;

/**
 * 没有重复元素集合的全排列
 */
public class UniqueEleFullPermutation {

    /**
     * 没有重复元素集合的全排列
     *
     * @param numbers 数组
     * @return 全排列
     */
    public static List<List<Integer>> permute(int[] numbers) {
        List<List<Integer>> result = new LinkedList<>();
        helper(numbers, 0, result);
        return result;
    }

    /**
     * 处理逻辑
     *
     * @param numbers 目标数组
     * @param index   索引
     * @param result  所有子集列表
     */
    private static void helper(int[] numbers, int index, List<List<Integer>> result) {
        if (index == numbers.length) {
            LinkedList<Integer> permutation = new LinkedList<>();
            for (int number : numbers) {
                permutation.add(number);
            }
            result.add(permutation);
        } else {
            for (int j = index; j < numbers.length; j++) {
                // 选定index位置数字
                swap(numbers, index, j);
                // 再选定index+1数字
                helper(numbers, index + 1, result);
                // 回置index位置数字
                swap(numbers, index, j);
            }
        }
    }

    /**
     * 元素交换
     *
     * @param numbers 目标数组
     * @param i       下标i
     * @param j       下标j
     */
    private static void swap(int[] numbers, int i, int j) {
        if (i != j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }
}
