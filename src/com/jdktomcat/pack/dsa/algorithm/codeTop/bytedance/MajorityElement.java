package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.util.jdk6.HashMap;

import java.util.Map;

/**
 * 多数元素
 */
public class MajorityElement {

    /**
     * 多数元素
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * @param numbers 数组
     * @return 多数元素
     */
    public static int majorityElement(int[] numbers) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        for (int number : numbers) {
            int value = dataMap.getOrDefault(number, 0) + 1;
            if (value > numbers.length / 2) {
                return number;
            }
            dataMap.put(number, value);
        }
        return -1;
    }

    /**
     * 多数元素
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * @param numbers 数组
     * @return 多数元素
     */
    public static int majorityElementL0(int[] numbers) {
        int count = 0;
        Integer candidate = null;
        for (int num : numbers) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }


    public static void main(String[] args) {

    }

}
