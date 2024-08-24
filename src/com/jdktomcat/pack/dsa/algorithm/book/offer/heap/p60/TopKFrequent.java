package com.jdktomcat.pack.dsa.algorithm.book.offer.heap.p60;

import java.util.*;

/**
 * 出现频率最高的k个数字
 */
public class TopKFrequent {

    /**
     * 出现频率最高的k个数字
     *
     * @param numbers 目标数组
     * @param k       目标大小
     * @return 列表
     */
    public static List<Integer> topKFrequent(int[] numbers, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        List<Integer> result = new ArrayList<>(minHeap.size());
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        return result;
    }

}
