package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.Arrays;

/**
 * 下一个排列
 */
public class NextPermute {

    /**
     * 下一个排列
     *
     * @param numbers 目标数组
     */
    public static void nextPermutation(int[] numbers) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            for (int j = numbers.length - 1; j > i; j--) {
                // 判断右位数字大于左位数字
                if (numbers[j] > numbers[i]) {
                    // 交换
                    swap(numbers, i, j);
                    // 排序（从索引i+1到尾），即为目标排列
                    Arrays.sort(numbers, i + 1, numbers.length);
                    return;
                }
            }
        }
        Arrays.sort(numbers);
    }

    /**
     * 交换数字
     *
     * @param numbers 目标数组
     * @param i       索引1
     * @param j       索引2
     */
    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
