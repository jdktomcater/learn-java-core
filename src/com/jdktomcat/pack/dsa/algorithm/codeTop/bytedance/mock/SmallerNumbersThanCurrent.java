package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallerNumbersThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int num : nums) {
            maxHeap.add(num);
        }
        Map<Integer, Integer> maxCountMap = new HashMap<>();
        while (!maxHeap.isEmpty()) {
            maxCountMap.put(maxHeap.poll(), maxHeap.size());
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = maxCountMap.get(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }
}
