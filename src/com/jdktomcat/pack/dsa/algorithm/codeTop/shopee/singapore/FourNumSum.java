package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 3; a++) {
            for (int b = a + 1; b < nums.length - 2; b++) {
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        int temp = nums[c];
                        while (c < nums.length - 1 && temp == nums[c]) {
                            c++;
                        }
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
                int temp = nums[b];
                while (b < nums.length - 3 && temp == nums[b + 1]) {
                    b++;
                }
            }
            int temp = nums[a];
            while (a < nums.length - 4 && temp == nums[a + 1]) {
                a++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        System.out.println(fourSum(numbers, target));
    }
}
