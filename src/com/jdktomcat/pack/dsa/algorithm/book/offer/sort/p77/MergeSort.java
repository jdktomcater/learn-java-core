package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p77;

import java.util.Arrays;

/**
 * 合并排序
 */
public class MergeSort {

    /**
     * 合并排序
     *
     * @param numbers 目标数组
     * @return 排序后数组
     */
    public static int[] mergeSortL3(int[] numbers) {
        int length = numbers.length;
        int[] src = numbers;
        int[] dst = new int[length];
        for (int seg = 1; seg < length; seg += seg) {
            for (int start = 0; start < length; start += seg * 2) {
                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);
                int i = start, j = mid, k = start;
                while (i < mid || j < end) {
                    if (j == end || (i < mid && src[i] < src[j])) {
                        dst[k++] = src[i++];
                    } else {
                        dst[k++] = src[j++];
                    }
                }
            }
            int[] temp = src;
            src = dst;
            dst = temp;
        }
        return src;
    }

    /**
     * 合并排序
     *
     * @param numbers 目标数组
     * @return 排序后数组
     */
    public static void mergeSortL2(int[] numbers) {
        mergeSort(numbers,0,numbers.length - 1);
    }

    /**
     * 合并排序
     *
     * @param numbers 目标数组
     * @param start   开始索引
     * @param end     截止索引
     */
    private static void mergeSort(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(numbers, start, mid );
        mergeSort(numbers, mid + 1, end);
        merge(numbers, start, mid, end);
    }

    /**
     * 合并区间
     *
     * @param numbers 目标数组
     * @param start   开始索引
     * @param mid     中间索引
     * @param end     截止索引
     */
    private static void merge(int[] numbers, int start, int mid, int end) {
        int index1 = start;
        int index2 = mid + 1;
        int index = 0;
        int[] mergeArr = new int[end - start + 1];
        while (index1 <= mid && index2 <= end) {
            if (numbers[index1] < numbers[index2]) {
                mergeArr[index++] = numbers[index1++];
            } else {
                mergeArr[index++] = numbers[index2++];
            }
        }
        while (index1 <= mid) {
            mergeArr[index++] = numbers[index1++];
        }
        while (index2 <= end) {
            mergeArr[index++] = numbers[index2++];
        }
        System.arraycopy(mergeArr, 0, numbers, start, mergeArr.length);
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{23, 1, 56, 34, 234, 6, 13, 24};
        mergeSortL2(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
