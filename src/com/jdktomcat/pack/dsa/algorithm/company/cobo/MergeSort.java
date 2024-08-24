package com.jdktomcat.pack.dsa.algorithm.company.cobo;

import java.util.Arrays;

public class MergeSort {

    /**
     * 归并排序
     *
     * @param target 目标数组
     * @param start  起始索引
     * @param end    结束索引
     */
    public static void mergeSort(int[] target, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(target, start, mid);
        mergeSort(target, mid + 1, end);
        merge(target, start, mid, end);
    }

    /**
     * 合并小数组
     *
     * @param target 目标数组
     * @param start  开始索引
     * @param mid    中间索引
     * @param end    结束索引
     */
    public static void merge(int[] target, int start, int mid, int end) {
        int index1 = start;
        int index2 = mid + 1;
        int index = 0;
        int[] mergeArr = new int[end - start + 1];
        while (index1 <= mid && index2 <= end) {
            if (target[index1] < target[index2]) {
                mergeArr[index++] = target[index1++];
            } else {
                mergeArr[index++] = target[index2++];
            }
        }
        while (index1 <= mid) {
            mergeArr[index++] = target[index1++];
        }
        while (index2 <= end) {
            mergeArr[index++] = target[index2++];
        }
        System.arraycopy(mergeArr, 0, target, start, mergeArr.length);
    }

    public static void main(String[] args) {
        int[] target = new int[]{4, 5, 8, 1, 7, 2, 3};
        mergeSort(target, 0, target.length - 1);
        System.out.println(Arrays.toString(target));
    }
}
