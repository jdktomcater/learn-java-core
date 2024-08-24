package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p75;

/**
 * 计数排序
 */
public class CountSort {

    /**
     * 计数排序
     *
     * @param numbers 原始数组
     * @return 排序后
     */
    public static void countSort(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] counts = new int[max - min + 1];
        for (int num : numbers) {
            counts[num - min]++;
        }
        int i = 0;
        for (int num = min; num <= max; num++) {
            while (counts[num - min] > 0) {
                numbers[i++] = num;
                counts[num - min]--;
            }
        }
    }
}
