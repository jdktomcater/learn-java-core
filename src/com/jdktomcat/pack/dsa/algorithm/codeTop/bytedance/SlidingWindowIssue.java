package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口最大值 滑动窗口相关问题
 */
public class SlidingWindowIssue {

    /**
     * 滑动窗口最大值
     *
     * @param numbers 数组
     * @param k       窗口大小
     * @return 结果
     */
    public static int[] maxSlidingWindowL0(int[] numbers, int k) {
        int[] result = new int[numbers.length - k + 1];
        int left = 0, right = k;
        int max = Integer.MIN_VALUE;
        while (right <= numbers.length) {
            if (left > 0) {
                if (numbers[left - 1] == max) {
                    if (numbers[right - 1] >= max) {
                        max = numbers[right - 1];
                    } else {
                        max = Integer.MIN_VALUE;
                        for (int i = left; i < right; i++) {
                            max = Math.max(max, numbers[i]);
                        }
                    }
                } else {
                    max = Math.max(max, numbers[right - 1]);
                }
            } else {
                for (int i = left; i < right; i++) {
                    max = Math.max(max, numbers[i]);
                }
            }
            result[left] = max;
            right++;
            left++;
        }
        return result;
    }

    /**
     * 滑动窗口最大值
     *
     * @param numbers 数组
     * @param k       窗口大小
     * @return 结果
     */
    public static int[] maxSlidingWindow(int[] numbers, int k) {
        // 边界条件
        if (numbers == null || k < 1 || numbers.length < k) {
            return null;
        }
        // 结果数组
        int[] result = new int[numbers.length - k + 1];
        // 结果数组索引
        int index = 0;
        // 最大值索引
        LinkedList<Integer> maxQueue = new LinkedList<>();
        // 遍历数组
        for (int i = 0; i < numbers.length; i++) {
            // 判断最大索引队列不为空且队列尾部索引对应的元素小于现在元素的话，需要将之前的弹出
            while (!maxQueue.isEmpty() && numbers[maxQueue.peekLast()] <= numbers[i]) {
                maxQueue.pollLast();
            }
            // 加入队列
            maxQueue.addLast(i);
            // 判断队列头部索引是否等于滑动窗口左边界
            if (maxQueue.peekFirst() != null && maxQueue.peekFirst() == i - k) {
                // 弹出左
                maxQueue.pollFirst();
            }
            // 当索引达到华东窗口右边界
            if (i >= k - 1 && maxQueue.peekFirst() != null) {
                result[index++] = numbers[maxQueue.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(numbers, k)));
    }

}
