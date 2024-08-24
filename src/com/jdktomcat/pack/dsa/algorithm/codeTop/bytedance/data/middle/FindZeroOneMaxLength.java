package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续数组
 * <p>
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class FindZeroOneMaxLength {

    /**
     * 最长子数组长度(前缀和+映射)
     *
     * @param numbers 目标数组
     * @return 子数组的长度
     */
    public static int findMaxLength(int[] numbers) {
        // 最大长度
        int maxLength = 0, counter = 0;
        // 和索引映射
        Map<Integer, Integer> map = new HashMap<>();
        map.put(counter, -1);
        // 数组遍历
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                maxLength = Math.max(maxLength, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

}
