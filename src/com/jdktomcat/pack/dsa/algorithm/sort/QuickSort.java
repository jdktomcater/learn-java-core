package com.jdktomcat.pack.dsa.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * 交换
     *
     * @param array  数组
     * @param index1 下标1
     * @param index2 下标2
     */
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        System.out.println("Arrays:" + Arrays.toString(array));
        System.out.println("swap index1:" + index1 + " data1:" + array[index1] + "index2:" + index2 + " data2:" + array[index2]);
    }

    private static void quickSort(int[] array, int start, int end) {
//        if (start < end) {
//            int target = array[start];
//            int leftIndex = start;
//            int rightIndex = end + 1;
//            while (true) {
//                while (leftIndex < end && array[++leftIndex] <= target) {
//                }
//                while (rightIndex > start && array[--rightIndex] >= target) {
//                }
//                if (leftIndex >= rightIndex) {
//                    break;
//                } else {
//                    swap(array, leftIndex, rightIndex);
//                }
//            }
//            swap(array, start, rightIndex);
//            quickSort(array, start, rightIndex - 1);
//            quickSort(array, rightIndex + 1, end);
//        }
        if(start<end){
            int temp=helper(array,start,end);
            quickSort(array,start,temp-1);
            quickSort(array,temp+1,end);
        }

    }

    private static int helper(int[] arr,int start,int end){
        int pix=arr[start];
        while(start<end){
            while(start<end && arr[end]>=pix) end--;
            arr[start]=arr[end];
            while(start<end && arr[start]<=pix) start++;
            arr[end]=arr[start];
        }
        arr[start]=pix;
        return start;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 9, 4, 24, 234, 567, 0};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}
