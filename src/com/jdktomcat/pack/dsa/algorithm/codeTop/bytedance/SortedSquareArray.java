package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;

/**
 * 有序数组的平方
 */
public class SortedSquareArray {
    /**
     * 数组排序平方
     *
     * @param numbers 数组
     * @return 平方排序数组
     */
    public static int[] sortedSquares(int[] numbers) {
        int[] sortedSquare = new int[numbers.length];
        for (int i = 0; i < sortedSquare.length; i++) {
            sortedSquare[i] = numbers[i] * numbers[i];
        }
        Arrays.sort(sortedSquare);
        return sortedSquare;
    }

}
