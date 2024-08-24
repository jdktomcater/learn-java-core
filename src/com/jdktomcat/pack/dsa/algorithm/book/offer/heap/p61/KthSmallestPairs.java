package com.jdktomcat.pack.dsa.algorithm.book.offer.heap.p61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 和最小的k个数对
 */
public class KthSmallestPairs {

    /**
     * 和最小的k个数对
     *
     * @param numbers1 数组1
     * @param numbers2 数组2
     * @param k        目标
     * @return 目标数对
     */
    public static List<List<Integer>> kSmallestPairs(int[] numbers1, int[] numbers2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] + p2[1] - p1[0] - p1[2]);
        for (int i = 0; i < Math.min(k, numbers1.length); i++) {
            for (int j = 0; j < Math.min(k, numbers2.length); j++) {
                if (maxHeap.size() >= k) {
                    int[] root = maxHeap.peek();
                    if (root[0] + root[1] > numbers1[i] + numbers2[j]) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{numbers1[i], numbers2[j]});
                    }
                } else {
                    maxHeap.offer(new int[]{numbers1[i], numbers2[j]});
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(maxHeap.size());
        while (!maxHeap.isEmpty()) {
            int[] pair = maxHeap.poll();
            result.add(Arrays.asList(pair[0], pair[1]));
        }
        return result;
    }

}
