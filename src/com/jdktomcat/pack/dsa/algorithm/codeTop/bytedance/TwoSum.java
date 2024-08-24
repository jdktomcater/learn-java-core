package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数和
 */
public class TwoSum {

    /**
     * 两数和为目标值下标索引
     *
     * @param numbers 数组
     * @param target  目标和
     * @return 索引
     */
    public static int[] twoSum(int[] numbers, int target) {
        // 哈希表缓存
        Map<Integer, Integer> countMap = new HashMap<>();
        // 循环处理
        for (int index = 0; index < numbers.length; index++) {
            // 先判断是否存在，再放入缓存
            if (countMap.containsKey(target - numbers[index])) {
                return new int[]{index, countMap.get(target - numbers[index])};
            }
            // 放入缓存
            countMap.put(numbers[index], index);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] numbers = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

}
