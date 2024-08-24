package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复最长子串
 */
public class NonRepeatLongestSubString {

    /**
     * 无重复最长子串长度
     *
     * @param s 目标字符串
     * @return 最长子串长度
     */
    public static int nonRepeatLongestSubStringL0(String s) {
        // 判断字符串长度，小于2的话，直接返回即可
        if (s.length() < 2) {
            return s.length();
        }
        // 最大长度变量
        int max = 0;
        // 左索引
        int left = 0;
        // 右索引
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // 查找其前索引
            int preIndex = s.indexOf(ch, left);
            // 判断其前索引小于右索引且不为-1
            if (preIndex < right && preIndex != -1) {
                max = Math.max(max, right - left);
                left = preIndex + 1;
            }
        }
        // 返回较大者
        return Math.max(max, s.length() - left);
    }

    /**
     * 无重复最长子串长度
     *
     * @param target 目标字符串
     * @return 最长子串长度
     */
    public static int nonRepeatLongestSubString(String target) {
        // 判断字符串长度，小于2的话，直接返回即可
        if (target.length() < 2) {
            return target.length();
        }
        // 最大长度变量
        int max = 0;
        // 左索引
        int left = 0;
        // 缓存字符索引映射
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < target.length(); right++) {
            char ch = target.charAt(right);
            // 直接放入到缓存，如果之前已经放入，则前值不为空；无则为空
            Integer prevIndex = map.put(ch, right);
            // 判断以下，注意要大于左索引值
            if (prevIndex != null && prevIndex >= left) {
                // 取较大值赋值
                max = Math.max(max, right - left);
                // 左索引在前索引+1
                left = prevIndex + 1;
            }
        }
        // 返回较大者
        return Math.max(max, target.length() - left);
    }

    public static void main(String[] args) {
        String target1 = "bbtablud";
        System.out.println(nonRepeatLongestSubStringL0(target1));
    }

}
