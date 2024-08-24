package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列列表
 */
public class AllPermuteList {

    /**
     * 全排列列表
     *
     * @param numbers 目标数组
     * @return 全排列列表
     */
    public static List<List<Integer>> permute(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(numbers, 0, result);
        return result;
    }

    /**
     * 深度计算逻辑
     *
     * @param numbers 数组
     * @param index   索引
     * @param result  结果
     */
    private static void dfs(int[] numbers, int index, List<List<Integer>> result) {
        if (index == numbers.length) {
            List<Integer> permute = new ArrayList<>();
            for (int number : numbers) {
                permute.add(number);
            }
            result.add(permute);
        } else if (index < numbers.length) {
            for (int i = index; i < numbers.length; i++) {
                swap(numbers, i, index);
                dfs(numbers, index + 1, result);
                swap(numbers, i, index);
            }
        }
    }

    /**
     * 数据交换
     *
     * @param numbers 数组
     * @param i       索引1
     * @param j       索引2
     */
    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        List<List<Integer>> result = permute(numbers);
        for (List<Integer> permute : result) {
            System.out.println(Arrays.toString(permute.toArray()));
        }
    }
}
