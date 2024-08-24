package com.jdktomcat.pack.dsa.algorithm.company.xiaomi.mid;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 */
public class FindKthLargestNumber {

    /**
     * 数组中的第K个最大元素
     *
     * @param numbers 目标数组
     * @param k       目标索引
     * @return 目标元素
     */
    public static int findKthLargest(int[] numbers, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : numbers) {
            if (minHeap.isEmpty() || minHeap.size() < k) {
                minHeap.offer(num);
            } else if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }


}
