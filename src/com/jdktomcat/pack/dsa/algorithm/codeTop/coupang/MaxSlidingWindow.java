package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 */
public class MaxSlidingWindow {

    /**
     * 滑动窗口最大值
     *
     * @param numbers 数组
     * @param k       窗口大小
     * @return 滑动窗口最大值数组
     */
    public static int[] maxSlidingWindow(int[] numbers, int k) {
        int[] result = new int[numbers.length - k + 1];
        // 单调递减索引双向队列
        Deque<Integer> maxQueue = new LinkedList<>();
        // 目标索引
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            // 保证队列中存最大值
            while (!maxQueue.isEmpty() && numbers[maxQueue.peekLast()] <= numbers[i]) {
                maxQueue.pollLast();
            }
            // 加入队列
            maxQueue.addLast(i);
            // 判断是否需要向右滑动（保证窗口大小为k）
            if (!maxQueue.isEmpty() && maxQueue.peekFirst() == i - k) {
                maxQueue.pollFirst();
            }
            // 如果索引大于等于k-1时需要获取最大值
            if (i >= k - 1) {
                result[index++] = numbers[maxQueue.peekFirst() == null ? 0 : maxQueue.peekFirst()];
            }
        }
        return result;
    }


    /**
     * 滑动窗口最大值
     *
     * @param numbers 数组
     * @param k       窗口大小
     * @return 滑动窗口最大值数组
     */
    public static int[] maxSlidingWindowL0(int[] numbers, int k) {
        int[] result = new int[numbers.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            while (!deque.isEmpty() && numbers[deque.peekLast()] <= numbers[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            if (i >= k - 1 && !deque.isEmpty()) {
                result[index++] = numbers[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindowL0(numbers, k)));
    }


}
