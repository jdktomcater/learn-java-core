package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.mock;

import java.util.Arrays;

public class Nearest {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return Arrays.stream(nums).sum();
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int dis = Math.abs(sum - target);
                if (dis < min) {
                    min = dis;
                    minSum = sum;
                }
                if (sum == target) {
                    break;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
            int temp = nums[i];
            while (temp == nums[i] && i < nums.length - 2) {
                i++;
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        int target = -100;
        System.out.println(threeSumClosest(nums, target));
    }
}
