package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 */
public class MinKNumber {

    /**
     * 最小的k个数
     *
     * @param arr 数组
     * @param k   阈值
     * @return 数组
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else {
                if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                    maxHeap.poll();
                    maxHeap.offer(num);
                }
            }
        }
        int[] min = new int[maxHeap.size()];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            min[index++] = maxHeap.poll();
        }
        return min;
    }

    /**
     * 最小的k个数
     *
     * @param arr 数组
     * @param k   阈值
     * @return 数组
     */
    public static int[] getLeastNumbersL0(int[] arr, int k) {
        if (arr.length <= k) {
            return arr;
        }
        int left = 0, right = arr.length - 1, target = arr[k - 1];
        while (true) {
            while (left++ < k && arr[left] < target) ;
            while (right-- > k && arr[right] > target) ;
            if (left < right) {
                swap(arr, left, right);
            } else {
                break;
            }
        }
        swap(arr, k - 1, right);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        System.out.println(Arrays.toString(getLeastNumbersL0(arr, k)));
    }

}
