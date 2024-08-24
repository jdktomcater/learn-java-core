package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class TrapRain {

    /**
     * 接雨水量 （双指针 n-0）
     *
     * @param heights 高度信息
     * @return 雨水量
     */
    public static int trapL0(int[] heights) {
        int left = 0, leftMax = 0, right = heights.length - 1, rightMax = 0, ans = 0;
        while (left < right) {
            if (heights[left] < heights[right]) {
                if (heights[left] > leftMax) {
                    leftMax = heights[left];
                } else {
                    ans += leftMax - heights[left];
                }
                left++;
            } else {
                if (heights[right] > rightMax) {
                    rightMax = heights[right];
                } else {
                    ans += rightMax - heights[right];
                }
                right--;
            }
        }
        return ans;
    }

    /**
     * 接雨水量 （单调栈）
     *
     * @param heights 高度信息
     * @return 雨水量
     */
    public static int trapL1(int[] heights) {
        int ans = 0;
        // 较低索引
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                int top = stack.pop();
                // 边界退出
                if (stack.isEmpty()) {
                    break;
                }
                // 左边界
                int left = stack.peek();
                // 宽度
                int curWidth = i - left - 1;
                // 高度，使用左右较小者来减去底高度
                int curHeight = Math.min(heights[left], heights[i]) - heights[top];
                ans += curWidth * curHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 接雨水量 （动态规划）
     *
     * @param heights 高度信息
     * @return 雨水量
     */
    public static int trapL2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        // 缓存每个节点左右最大值
        int[][] dp = new int[heights.length][2];
        dp[0][0] = heights[0];
        dp[heights.length - 1][1] = heights[heights.length - 1];
        for (int i = 1; i < heights.length; ++i) {
            // 左最大值
            dp[i][0] = Math.max(dp[i - 1][0], heights[i]);
            // 右最大值
            dp[heights.length - 1 - i][1] = Math.max(dp[heights.length - i][1], heights[heights.length - 1 - i]);
        }
        int ans = 0;
        for (int i = 0; i < heights.length; ++i) {
            // 计算雨水量
            ans += Math.min(dp[i][0], dp[i][1]) - heights[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapL2(numbers));
    }
}
