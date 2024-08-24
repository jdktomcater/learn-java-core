package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    int temp = nums[j];
                    while (j < nums.length - 1 && temp == nums[j]) {
                        j++;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            int temp = nums[i];
            while (temp == nums[i] && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> path : result) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
