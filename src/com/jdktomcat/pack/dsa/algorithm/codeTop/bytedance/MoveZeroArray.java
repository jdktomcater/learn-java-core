package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;

/**
 * 移动零
 */
public class MoveZeroArray {

    /**
     * 移动零
     *
     * @param numbers 数组
     */
    public static void moveZeroes(int[] numbers) {
        for (int i = 0; i < numbers.length && !isAllZero(numbers, i); i++) {
            while (numbers[i] == 0) {
                int j = i;
                while (j < numbers.length - 1) {
                    swap(numbers, j, ++j);
                }
            }
        }
    }

    /**
     * 移动零
     *
     * @param numbers 数组
     */
    public static void moveZeroesL0(int[] numbers) {
        for (int i = numbers.length - 1; i >= 0; i++) {
            while (numbers[i] == 0) {
                int j = i;
                while (numbers[j+1]!=0 && j < numbers.length - 1) {
                    swap(numbers, j, ++j);
                }
            }
        }
    }

    /**
     * 移动零
     *
     * @param numbers 数组
     */
    public static void moveZeroesL1(int[] numbers) {
        int left = 0, right = 0;
        while (right < numbers.length) {
            if (numbers[right] != 0) {
                swap(numbers, left, right);
                left++;
            }
            right++;
        }
    }



    /**
     * 判断是否全为0
     *
     * @param numbers 数组
     * @param start   开始索引
     * @return true：是 false：否
     */
    private static boolean isAllZero(int[] numbers, int start) {
        for (int i = start; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数组下标数据交换
     *
     * @param numbers 数组
     * @param i       下标1
     * @param j       下标2
     */
    private static void swap(int[] numbers, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 1};
        moveZeroes(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
