package com.jdktomcat.pack.dsa.algorithm.book.offer.sort;

import java.util.Arrays;

/**
 * 数组相对排序
 */
public class Problem75 {

    /**
     * 处理函数
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 计数排序后数组
     */
    public static void relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }
        int index = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                arr1[index++] = num;
                counts[num]--;
            }
        }
        for (int num = 0; num < counts.length; num++) {
            while (counts[num] > 0) {
                arr1[index++] = num;
                counts[num]--;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 3, 7, 3, 9, 2, 1, 7, 2};
        int[] arr2 = new int[]{3, 2, 1};
        relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
    }

}
