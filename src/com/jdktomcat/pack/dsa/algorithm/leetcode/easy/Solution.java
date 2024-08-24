package com.jdktomcat.pack.dsa.algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        if (stones.length > 1 && stones[stones.length - 2] != 0) {
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            return lastStoneWeight(stones);
        } else if (stones.length > 1 && stones[stones.length - 2] == 0) {
            return stones[stones.length - 1];
        }
        return stones[stones.length - 1];
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int length = s.length();
        int i = 0;
        int iterator = t.indexOf(s.charAt(i));
        while (i++ < length - 1 && iterator != -1) {
            int iterTemp = t.indexOf(s.charAt(i), iterator + 1);
            if (iterTemp < iterator) {
                return false;
            }
            iterator = iterTemp;
        }
        if (iterator == -1) {
            return false;
        }
        return true;
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            dataMap.put(nums[index], target - nums[index]);
            indexMap.put(nums[index], index);
        }
        for (Map.Entry<Integer, Integer> entry : dataMap.entrySet()) {
            if (dataMap.containsKey(entry.getValue())) {
                return new int[]{indexMap.get(entry.getKey()), indexMap.get(entry.getValue())};
            }
        }
        return new int[]{};
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        int in = 0, in1 = 0, in2 = 0;
        while (in1 < nums1.length && in2 < nums2.length) {
            if (nums1[in1] < nums2[in2]) {
                num[in++] = nums1[in1++];
            } else if (nums1[in1] == nums2[in2]) {
                num[in++] = nums1[in1++];
                num[in++] = nums2[in2++];
            } else {
                num[in++] = nums2[in2++];
            }
        }
        if (in1 < nums1.length) {
            for (int index = in1; index < nums1.length; index++) {
                num[in++] = nums1[index];
            }
        }
        if (in2 < nums2.length) {
            for (int index = in2; index < nums2.length; index++) {
                num[in++] = nums2[index];
            }
        }
        if ((num.length - 1) % 2 == 0) {
            return num[(num.length - 1) / 2];
        }
        return (num[(num.length - 1) / 2] + num[(num.length - 1) / 2 + 1]) / 2.0;
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        String target = "";
        for (int index = 0; index < length; index++) {
            String next = s.substring(index, index + 1);
            if (length != 1 && index < length - 1) {
                if (s.charAt(index) == s.charAt(length - 1)) {
                    next += longestPalindrome(s.substring(index + 1, length - 1));
                    next += s.substring(length - 1, length);
                } else {
                    next = longestPalindrome(s.substring(index, length - 1));
                }
            }
            if (target.length() < next.length()) {
                target = next;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdefiedcj"));
    }
}
