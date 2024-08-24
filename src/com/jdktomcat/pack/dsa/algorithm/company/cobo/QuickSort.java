package com.jdktomcat.pack.dsa.algorithm.company.cobo;

import java.util.Arrays;

public class QuickSort {

    /**
     * 交换数据
     *
     * @param target 目标数组
     * @param index1 索引1
     * @param index2 索引2
     */
    private static void swap(int[] target, int index1, int index2) {
        int temp = target[index1];
        target[index1] = target[index2];
        target[index2] = temp;
    }

    /**
     * 快速排序
     *
     * @param target 目标数组
     * @param start  开始索引
     * @param end    结束索引
     */
    public static void quickSort(int[] target, int start, int end) {
        if (start < end) {
            int left = start;
            int right = end + 1;
            int bench = target[start];
            while (true) {
                while (left <= end && target[++left] < bench) ;
                while (right >= start && target[--right] > bench) ;
                if (left < right) {
                    swap(target, left, right);
                } else {
                    break;
                }
            }
            swap(target, start, right);
            quickSort(target, start, right - 1);
            quickSort(target, right + 1, end);
        }
    }


    public static void main(String[] args) {
        int[] target = new int[]{4, 5, 8, 1, 7, 2, 3};
        quickSort(target, 0, target.length - 1);
        System.out.println(Arrays.toString(target));
    }


}
