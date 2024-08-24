package com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p39;

import java.util.Stack;

/**
 * 直方图最大矩形面积
 */
public class LargestRectangleArea {

    /**
     * 蛮力计算
     *
     * @param heights 高度信息
     * @return 最大矩形面积
     */
    public static int largestRectangleAreaL3(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    /**
     * 分治法
     *
     * @param heights 高度信息
     * @return 最大矩形面积
     */
    public static int largestRectangleAreaL2(int[] heights) {
        return helper(heights, 0, heights.length);
    }

    /**
     * 分治法逻辑
     *
     * @param heights 高度信息
     * @param start   开始索引
     * @param end     结束索引
     * @return 最大矩形面积
     */
    private static int helper(int[] heights, int start, int end) {
        if (start == end) {
            return 0;
        }
        if (start + 1 == end) {
            return heights[start];
        }
        int minIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        int area = (end - start) * heights[minIndex];
        int left = helper(heights, start, minIndex);
        int right = helper(heights, minIndex + 1, end);
        area = Math.max(area, left);
        return Math.max(area, right);
    }

    /**
     * 栈计算
     *
     * @param heights 高度信息
     * @return 最大矩形面积
     */
    public static int largestRectangleAreaL1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

}
