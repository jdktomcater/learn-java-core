package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 */
public class KthTargetNumber {

    /**
     * 数组中k大的元素
     *
     * @param numbers 目标数组
     * @param k       目标索引
     * @return 目标元素
     */
    public int findKthLargestL2(int[] numbers, int k) {
        if (k > numbers.length) {
            return -1;
        }
        Arrays.sort(numbers);
        return numbers[numbers.length - k - 1];
    }

    /**
     * 数组中k大的元素
     *
     * @param numbers 目标数组
     * @param k       目标索引
     * @return 目标元素
     */
    public int findKthLargestL1(int[] numbers, int k) {
        if (k > numbers.length) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            if (minHeap.size() < k) {
                minHeap.offer(number);
            } else if (minHeap.peek() != null && minHeap.peek() < number) {
                minHeap.poll();
                minHeap.offer(number);
            }
        }
        return minHeap.peek() == null ? -1 : minHeap.peek();
    }

    /**
     * 数组中k大的元素
     *
     * @param numbers 目标数组
     * @param k       目标索引
     * @return 目标元素
     */
    public static int findKthLargestL3(int[] numbers, int k) {
        if (k > numbers.length) {
            return -1;
        }
        int start = 0;
        int end = numbers.length - 1;
        int pivot = pivot(numbers, start, end);
        while (pivot != -1) {
            if (pivot + k == numbers.length) {
                return numbers[pivot];
            } else if (pivot + k < numbers.length) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
            pivot = pivot(numbers, start, end);
        }
        return -1;
    }

    private static int pivot(int[] numbers, int start, int end) {
        if (start <= end) {
            int target = numbers[start];
            int left = start;
            int right = end + 1;
            while (true) {
                while (left < end && numbers[++left] < target) ;
                while (right > start && numbers[--right] > target) ;
                if (left < right) {
                    swap(numbers, left, right);
                } else {
                    break;
                }
            }
            swap(numbers, start, right);
            return right;
        }
        return -1;
    }

    /**
     * 数据交换
     *
     * @param numbers 数组
     * @param i       索引1
     * @param j       索引2
     */
    private static void swap(int[] numbers, int i, int j) {
        if (i != j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1};
        int k = 1;
        System.out.println(findKthLargestL3(numbers, k));
    }
}
