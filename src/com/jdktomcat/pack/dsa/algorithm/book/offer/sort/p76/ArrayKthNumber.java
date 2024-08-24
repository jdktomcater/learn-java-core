package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p76;

/**
 * 数组中第k大的数字
 */
public class ArrayKthNumber {

    /**
     * 查找第k大的数字
     *
     * @param numbers 数组
     * @param k       目标索引
     * @return 目标数字
     */
    public static int kthNum(int[] numbers, int k) {
        int targetIndex = numbers.length - k;
        int start = 0;
        int end = numbers.length - 1;
        int pivot = QuickSort.partition(numbers, start, end);
        while (targetIndex != pivot) {
            if (targetIndex < pivot) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }
            pivot = QuickSort.partition(numbers, start, end);
        }
        return numbers[pivot];
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{23, 1, 56, 34, 234, 6, 13, 24};
        System.out.println(kthNum(numbers, 4));
    }

}
