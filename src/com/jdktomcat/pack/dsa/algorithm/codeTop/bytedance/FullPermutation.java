package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class FullPermutation {

    /**
     * 全排列
     *
     * @param numbers 目标数组
     * @return 排列列表
     */
    public static List<List<Integer>> permutation(int[] numbers) {
        // 结果
        List<List<Integer>> result = new ArrayList<>();
        // 回溯深度遍历
        dfs(numbers, 0, result);
        // 返回结果
        return result;
    }

    /**
     * 回溯深度遍历
     *
     * @param numbers 数组
     * @param index   索引
     * @param result  结果
     */
    private static void dfs(int[] numbers, int index, List<List<Integer>> result) {
        // 当索引等于数组长度时截止
        if (index == numbers.length) {
            // 此时数组即为一个排列
            List<Integer> permutation = new LinkedList<>();
            for (int num : numbers) {
                permutation.add(num);
            }
            // 保存结果
            result.add(permutation);
        } else {
            // 遍历，从所传下标开始
            for (int j = index; j < numbers.length; j++) {
                // 交换下标数据
                swap(numbers, index, j);
                // 回溯深度遍历
                dfs(numbers, index + 1, result);
                // 回置交换
                swap(numbers, index, j);
            }
        }
    }

    /**
     * 交换位置
     *
     * @param numbers 目标数组
     * @param i       索引1
     * @param j       索引2
     */
    private static void swap(int[] numbers, int i, int j) {
        if (i != j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        List<List<Integer>> result = permutation(numbers);
        for (List<Integer> permutation : result) {
            System.out.println(Arrays.toString(permutation.toArray()));
        }
    }
}
