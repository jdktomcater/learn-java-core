package com.jdktomcat.interview.tiktok;

import java.util.HashMap;
import java.util.Map;

public class CountNumber {

    /**
     * 判断数组中数字出现次数
     *
     * @param numbers 数组
     * @param target  目标数字
     * @return 出现次数
     */
    public static int countMap(int[] numbers, int target) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : numbers) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return countMap.getOrDefault(target, 0);
    }

    /**
     * 判断数组中数字出现次数
     *
     * @param numbers 数组
     * @param target  目标数字
     * @return 出现次数
     */
    public static int count(int[] numbers, int target) {
        int count = 0;
        for (int num : numbers) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
