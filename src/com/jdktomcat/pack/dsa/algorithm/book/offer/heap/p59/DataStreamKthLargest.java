package com.jdktomcat.pack.dsa.algorithm.book.offer.heap.p59;

import java.util.PriorityQueue;

/**
 * 数据流的第k大数字
 */
public class DataStreamKthLargest {

    private PriorityQueue<Integer> minHeap;

    private int size;

    public DataStreamKthLargest(int k, int[] numbers) {
        size = k;
        minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            add(number);
        }
    }

    /**
     * 新增元素
     *
     * @param number 数字
     * @return 返回最小值
     */
    private int add(Integer number) {
        if (minHeap.size() < size) {
            minHeap.offer(number);
        } else if (number > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(number);
        }
        return minHeap.peek();
    }

}
