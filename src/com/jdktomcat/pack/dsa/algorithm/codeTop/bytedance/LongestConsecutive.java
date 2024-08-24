package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;


import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列
 */
public class LongestConsecutive {

    /**
     * 最长连续序列长度
     *
     * @param numbers 数组
     * @return 最长连续序列长度
     */
    public static int longestConsecutive(int[] numbers) {
        if(numbers==null || numbers.length == 0){
            return 0;
        }
        Map<Integer, Boolean> dataMap = new HashMap<>();
        for (int num : numbers) {
            dataMap.put(num, true);
        }
        int max = 1;
        for (int num : numbers) {
            dataMap.remove(num);
            int up = num + 1;
            while (dataMap.containsKey(up)) {
                dataMap.remove(up);
                up = up + 1;
            }
            int down = num - 1;
            while (dataMap.containsKey(down)) {
                dataMap.remove(down);
                down = down - 1;
            }
            max = Math.max(up - down - 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(numbers));
    }

}
