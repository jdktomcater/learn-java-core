package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.easy;

/**
 * 合并有序数组
 */
public class MergeSortArray {

    /**
     * 合并数组
     *
     * @param numbers1 数组1
     * @param m 长度1
     * @param numbers2 数组2
     * @param n 长度2
     */
    public static void merge(int[] numbers1, int m, int[] numbers2, int n) {
        int index1 = 0, index2 = 0;
        while (m > 0 && n > 0) {
            if (numbers1[index1] > numbers2[index2]) {
                leftMove(numbers1, index1);
                numbers1[index1] = numbers2[index2];
                index2++;
                n--;
            } else {
                m--;
            }
            index1++;
        }
        if (n != 0) {
            while (n-- > 0) {
                numbers1[index1++] = numbers2[index2++];
            }
        }
    }

    private static void leftMove(int[] numbers, int start) {
        for (int i = numbers.length - 1; i > start; i--) {
            numbers[i] = numbers[i - 1];
        }
    }
}
