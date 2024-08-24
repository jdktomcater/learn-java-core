package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 盛最多水的容器
 */
public class HoldMoreWater {

    /**
     * 盛最多水的容器
     *
     * @param height 数组
     * @return 最大区域
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

}
