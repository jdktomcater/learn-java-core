package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.PriorityQueue;

public class KthLargestNumber {

    /**
     * 第k大数字（最小堆）
     *
     * @param nums 目标数字
     * @param k 目标阈值
     * @return 第k大数字
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return !minHeap.isEmpty() ? minHeap.peek() : 0;
    }
}
