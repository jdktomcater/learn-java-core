package com.jdktomcat.pack.dsa.algorithm.company.cobo;

import java.util.Arrays;

public class MergeArray {


    /**
     * 合并有序数组
     *
     * @param array1 数组1
     * @param array2 数组2
     * @return 合并后数组
     */
    public static int[] mergeArray(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int[] mergeArray = new int[length1 + length2];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index < mergeArray.length) {
            if (index1 == length1 && index2 < length2) {
                mergeArray[index] = array2[index2];
                index2++;
            } else if (index1 < length1 && index2 == length2) {
                mergeArray[index] = array1[index1];
                index1++;
            } else {
                mergeArray[index] = Math.min(array1[index1], array2[index2]);
                if (array1[index1] < array2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            }
            index++;
        }
        return mergeArray;
    }


    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 5, 7, 9};
        int[] array2 = new int[]{2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(mergeArray(array1, array2)));
    }

}
