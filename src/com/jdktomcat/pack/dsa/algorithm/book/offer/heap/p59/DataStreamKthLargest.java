package com.jdktomcat.pack.dsa.algorithm.book.offer.heap.p59;

import java.util.PriorityQueue;

/**
 * 数据流的第k大数字
 */
public class DataStreamKthLargest {

    private final PriorityQueue<Integer> minHeap;

    private final int size;

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
     */
    public void add(Integer number) {
        if (minHeap.size() < size) {
            minHeap.offer(number);
        } else if (!minHeap.isEmpty() && number > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(number);
        }
    }

    public int getKthLargest() {
        return !minHeap.isEmpty() ? minHeap.peek() : -1;
    }
}
