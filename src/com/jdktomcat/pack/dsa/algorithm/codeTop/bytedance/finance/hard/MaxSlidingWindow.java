package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 */
public class MaxSlidingWindow {
    /**
     * 最大滑动窗口
     *
     * @param nums 数组
     * @param k    目标阈值
     * @return 最大滑动窗口
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxSlidingWindow = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            if (!deque.isEmpty() && i >= k - 1) {
                maxSlidingWindow[index++] = nums[deque.peekFirst()];
            }
        }
        return maxSlidingWindow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
