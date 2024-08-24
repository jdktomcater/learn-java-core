package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {

    /**
     * 查找第k大的数字
     *
     * @param numbers 数组
     * @param k       序
     * @return 目标
     */
    public static int findKthLargest(int[] numbers, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : numbers) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (minHeap.peek() < num) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {

    }

}
