package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 罗马数字转整数
 */
public class RomanToInteger {

    private static Map<Character, Integer> ROMAN_INT_MAP = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };
    private static Map<Character, Set<Character>> PART_ROMAN_MAP = new HashMap<Character, Set<Character>>() {
        {
            put('I', new HashSet<Character>() {{
                add('V');
                add('X');
            }});
            put('X', new HashSet<Character>() {{
                add('L');
                add('C');
            }});
            put('C', new HashSet<Character>() {{
                add('D');
                add('M');
            }});
        }
    };

    /**
     * 转换后数字
     *
     * @param roman 罗马数字
     * @return 转换后数字
     */
    public static int romanToInt(String roman) {
        int sum = 0;
        for (int i = 0; i < roman.length(); i++) {
            char ch = roman.charAt(i);
            if (i < roman.length() - 1 && PART_ROMAN_MAP.containsKey(ch)) {
                char nextCh = roman.charAt(i + 1);
                Set<Character> set = PART_ROMAN_MAP.get(ch);
                if (set.contains(nextCh)) {
                    sum += (ROMAN_INT_MAP.getOrDefault(nextCh, 0) - ROMAN_INT_MAP.getOrDefault(ch, 0));
                    i++;
                } else {
                    sum += ROMAN_INT_MAP.getOrDefault(ch, 0);
                }
            } else {
                sum += ROMAN_INT_MAP.getOrDefault(ch, 0);
            }
        }
        return sum;
    }

}
