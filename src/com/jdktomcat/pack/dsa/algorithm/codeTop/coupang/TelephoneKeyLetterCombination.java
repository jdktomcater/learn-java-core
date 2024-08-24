package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.*;

/**
 * 电话号码的字母组合
 */
public class TelephoneKeyLetterCombination {

    static Map<Character, List<Character>> DIGIT_LETTER_MAP = new HashMap<Character, List<Character>>() {
        {
            put('2', new ArrayList<Character>() {
                {
                    add('a');
                    add('b');
                    add('c');
                }
            });
            put('3', new ArrayList<Character>() {
                {
                    add('d');
                    add('e');
                    add('f');
                }
            });
            put('4', new ArrayList<Character>() {
                {
                    add('g');
                    add('h');
                    add('i');
                }
            });
            put('5', new ArrayList<Character>() {
                {
                    add('j');
                    add('k');
                    add('l');
                }
            });
            put('6', new ArrayList<Character>() {
                {
                    add('m');
                    add('n');
                    add('o');
                }
            });
            put('7', new ArrayList<Character>() {
                {
                    add('p');
                    add('q');
                    add('r');
                    add('s');
                }
            });
            put('8', new ArrayList<Character>() {
                {
                    add('t');
                    add('u');
                    add('v');
                }
            });
            put('9', new ArrayList<Character>() {
                {
                    add('w');
                    add('x');
                    add('y');
                    add('z');
                }
            });
        }
    };

    /**
     * 电话号码的字母组合
     *
     * @param digits 电话数字
     * @return 电话号码的字母组合列表
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits != null && digits.length() != 0) {
            dfs(digits, 0, "", result);
        }
        return result;
    }

    /**
     * 深度遍历计算逻辑
     *
     * @param digits      目标数字字符串
     * @param index       索引
     * @param combination 字母组合
     * @param result      结果
     */
    private static void dfs(String digits, int index, String combination, List<String> result) {
        if (index == digits.length()) {
            result.add(combination);
        } else {
            char ch = digits.charAt(index);
            List<Character> letterList = DIGIT_LETTER_MAP.getOrDefault(ch, new ArrayList<>());
            for (char letter : letterList) {
                dfs(digits, index + 1, combination + letter, result);
            }
        }
    }

}
