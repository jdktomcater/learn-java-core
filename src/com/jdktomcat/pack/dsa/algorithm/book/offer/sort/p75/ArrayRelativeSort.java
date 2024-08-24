package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p75;

import java.util.Arrays;

/**
 * 数组相对排序
 */
public class ArrayRelativeSort {

    /**
     * 数组相对排序
     *
     * @param array1 数组1
     * @param array2 数组2
     */
    public static void arrayRelativeSort(int[] array1, int[] array2) {
        int[] counts = new int[1001];
        for (int num : array1) {
            counts[num]++;
        }
        int i = 0;
        for (int num : array2) {
            while (counts[num] > 0) {
                array1[i++] = num;
                counts[num]--;
            }
        }
        for (int num = 0; num < counts.length; num++) {
            while (counts[num] > 0) {
                array1[i++] = num;
                counts[num]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 3, 3, 7, 3, 9, 2, 1, 7, 2};
        int[] array2 = new int[]{3, 2, 1};
        arrayRelativeSort(array1, array2);
        System.out.println(Arrays.toString(array1));
    }
}
