package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 */
public class FindKthLargestNumber {
    /**
     * 数组中的第K个最大元素
     *
     * @param numbers 数组
     * @param k       阈值
     * @return 数组中的第K个最大元素
     */
    public static int findKthLargest(int[] numbers, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            if (minHeap.size() < k) {
                minHeap.offer(number);
            } else {
                if (!minHeap.isEmpty() && minHeap.peek() < number) {
                    minHeap.poll();
                    minHeap.offer(number);
                }
            }
        }
        return minHeap.peek();
    }

    /**
     * 数组中的第K个最大元素
     *
     * @param numbers 数组
     * @param k       阈值
     * @return 数组中的第K个最大元素
     */
    public static int findKthLargestL0(int[] numbers, int k) {
        int start = 0, end = numbers.length - 1;
        int pivot = pivot(numbers, start, end);
        while (pivot + k != numbers.length) {
            if (pivot + k < numbers.length) {
                start = pivot + 1;
                pivot = pivot(numbers, start, end);
            } else {
                end = pivot - 1;
                pivot = pivot(numbers, start, end);
            }
        }
        return numbers[numbers.length - k];
    }

    /**
     * 区分值
     *
     * @param numbers 数组
     * @param start   开始索引
     * @param end     结束索引
     * @return 区分值
     */
    private static int pivot(int[] numbers, int start, int end) {
        int left = start, right = end + 1, target = numbers[start];
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

    /**
     * 数据交换
     *
     * @param numbers 数组
     * @param i       索引1
     * @param j       索引2
     */
    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargestL0(numbers, k));
    }
}
