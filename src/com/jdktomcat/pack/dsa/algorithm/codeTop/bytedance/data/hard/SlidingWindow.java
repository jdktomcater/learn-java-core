package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.hard;

import java.util.LinkedList;

/**
 * 滑动窗口
 */
public class SlidingWindow {
    /**
     * 最大滑动窗口
     *
     * @param numbers 目标数组
     * @param k       目标值
     * @return 最大数组
     */
    public int[] maxSlidingWindow(int[] numbers, int k) {
        // 边界设置
        if (numbers == null || k < 1 || numbers.length < k) {
            return null;
        }
        // 结果数组
        int[] result = new int[numbers.length - k + 1];
        // 最大单调队列（存储索引，单调递减 从左到右）
        LinkedList<Integer> maxQueue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            // 判断最小值是否小于索引值
            while (!maxQueue.isEmpty() && numbers[maxQueue.peekLast()] <= numbers[i]) {
                // 弹出
                maxQueue.pollLast();
            }
            // 追加队尾
            maxQueue.addLast(i);
            // 判断头步索引是否超过了左边界
            if (!maxQueue.isEmpty() && maxQueue.peekFirst() == i - k) {
                // 弹出头部
                maxQueue.pollFirst();
            }
            // 判断开始边界
            if (i >= k - 1 && !maxQueue.isEmpty()) {
                // 设置其数值
                result[index++] = numbers[maxQueue.peekFirst()];
            }
        }
        return result;
    }
}
