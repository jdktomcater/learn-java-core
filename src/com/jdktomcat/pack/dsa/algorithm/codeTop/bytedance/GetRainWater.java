package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Stack;

/**
 * 接雨水
 */
public class GetRainWater {

    /**
     * 接雨水（双指针）
     *
     * @param heights 槽信息
     * @return 雨水
     */
    public static int trapL1(int[] heights) {
        // 雨水量
        int ans = 0;
        // 左右索引
        int left = 0, right = heights.length - 1;
        // 左右最大值
        int leftMax = 0, rightMax = 0;
        // 不需要相等,相等时,同时指向最大值,在最高点不会有雨水的
        while (left < right) {
            // 判断左最大值
            leftMax = Math.max(leftMax, heights[left]);
            // 判断右最大值
            rightMax = Math.max(rightMax, heights[right]);
            // 如果左小于右
            if (heights[left] < heights[right]) {
                // 雨水量
                ans += leftMax - heights[left++];
            } else {
                // 雨水量
                ans += rightMax - heights[right--];
            }
        }
        return ans;
    }

    /**
     * 接雨水（动态规划）
     *
     * @param heights 数组
     * @return 雨水量
     */
    public static int trapL0(int[] heights) {
        // 槽数量
        if (heights.length == 0) {
            return 0;
        }
        // 左侧最大值数组
        int[] leftMax = new int[heights.length];
        // 初始值
        leftMax[0] = heights[0];
        // 处理剩余逻辑，与左侧最大值比较
        for (int i = 1; i < heights.length; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        // 右侧最大值数组
        int[] rightMax = new int[heights.length];
        // 初始值
        rightMax[heights.length - 1] = heights[heights.length - 1];
        // 处理剩余逻辑，与右侧最大值比较
        for (int i = heights.length - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }
        // 计算雨水量
        int ans = 0;
        for (int i = 0; i < heights.length; ++i) {
            // 取两侧最小值减去该高度
            ans += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return ans;
    }

    /**
     * 接雨水（栈）
     *
     * @param heights 数组
     * @return 雨水量
     */
    public static int trapL2(int[] heights) {
        // 雨水量
        int ans = 0;
        // 缓存栈，下标索引 高度递减
        Stack<Integer> stack = new Stack<>();
        // 遍历
        for (int i = 0; i < heights.length; ++i) {
            // 栈不为空且目前高度大于栈顶下标对应的高度
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                // 弹出栈顶元素
                int top = stack.pop();
                // 如果为空，则返回
                if (stack.isEmpty()) {
                    break;
                }
                // 左侧
                int left = stack.peek();
                // 宽度
                int currWidth = i - left - 1;
                // 高度
                int currHeight = Math.min(heights[left], heights[i]) - heights[top];
                // 雨水量
                ans += currWidth * currHeight;
            }
            // 推入
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapL2(heights));
    }
}
