package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.hard;

/**
 * 接雨水
 */
public class TrapRainWater {

    /**
     * 接雨水（双指针）
     *
     * @param heights 槽信息
     * @return 雨水
     */
    public static int trap(int[] heights) {
        int ans = 0, left = 0, right = heights.length - 1, leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, heights[left]);
            rightMax = Math.max(rightMax, heights[right]);
            if (heights[left] < heights[right]) {
                ans += leftMax - heights[left++];
            } else {
                ans += rightMax - heights[right--];
            }
        }
        return ans;
    }
}
