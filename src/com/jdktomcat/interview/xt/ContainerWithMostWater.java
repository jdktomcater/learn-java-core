package com.jdktomcat.interview.xt;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max = Math.max(Math.min(height[right], height[left]) * (right - left), max);
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1};
        System.out.println(maxArea(height));
    }

}
