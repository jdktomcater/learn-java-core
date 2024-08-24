package com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p38;

import java.util.Stack;

/**
 * 每日温度
 */
public class DailyTemperatures {

    /**
     * 每日温度
     *
     * @param temperatures 温度信息
     * @return 结果
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }
            stack.push(i);
        }
        return result;
    }

}
