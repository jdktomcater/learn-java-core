package com.jdktomcat.pack.dsa.algorithm.company.cobo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopK {

    /**
     * topK算法实现
     *
     * @param data 数组
     * @param k    目标
     * @return 结果
     */
    public static int[] topK(int[] data, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int num : data) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
                continue;
            }
            Integer peek = priorityQueue.peek();
            if (num > peek) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
        int[] priResult = new int[priorityQueue.size()];
        for (int index = 0; index < priResult.length; index++) {
            priResult[index] = priorityQueue.poll();
        }
        return priResult;
    }


    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int k = 10;
        System.out.println(Arrays.toString(topK(data, k)));
    }
}
