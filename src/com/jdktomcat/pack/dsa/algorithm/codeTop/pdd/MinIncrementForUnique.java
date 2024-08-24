package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd;

import java.util.*;

/**
 * 使数组唯一的最小增量
 */
public class MinIncrementForUnique {

    /**
     * 使数组唯一的最小增量
     *
     * @param nums 数组
     * @return 操作最小次数
     */
    public static int minIncrementForUnique(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        countMap.forEach((key, value) -> {
            if (value > 1) {
                queue.offer(key);
            }
        });
        while (!queue.isEmpty()) {
            int num = queue.peek();
            int in = num;
            while (countMap.containsKey(in)) {
                step++;
                in++;
            }
            countMap.put(in, 1);
            int value = countMap.get(num) - 1;
            if (value <= 1) {
                queue.poll();
            }
            countMap.put(num, value);
        }
        return step;
    }

    /**
     * 使数组唯一的最小增量
     *
     * @param nums 数组
     * @return 最小增量
     */
    public static int minIncrementForUniqueL0(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, taken = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                taken++;
                ans -= nums[i];
            } else {
                int give = Math.min(taken, nums[i] - nums[i - 1] - 1);
                ans += give * (give + 1) / 2 + give * nums[i - 1];
                taken -= give;
            }
        }
        if (nums.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * nums[nums.length - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1};
        System.out.println(minIncrementForUnique(nums));
    }

}
