package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p84;

import java.util.*;

/**
 * 包含重复元素全排列
 */
public class ContainSameEleFullPermutation {

    /**
     * 没有重复元素集合的全排列
     *
     * @param numbers 数组
     * @return 全排列
     */
    public static List<List<Integer>> permute(int[] numbers) {
        Arrays.sort(numbers);
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
            // 防重集合
            Set<Integer> set = new HashSet<>();
            for (int j = index; j < numbers.length; j++) {
                // 判断元素是否已经添加在此位置上已经出现过
                if (!set.contains(numbers[j])) {
                    // 添加到集合
                    set.add(numbers[j]);
                    swap(numbers, index, j);
                    helper(numbers, index + 1, result);
                    swap(numbers, index, j);
                }
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
