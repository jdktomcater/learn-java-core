package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效的括号
 */
public class ValidPair {

    /**
     * 有效的括号
     *
     * @param s 目标字符串
     * @return true:是 false:否
     */
    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && checkPair(stack.peekLast(), ch)) {
                stack.pollLast();
            } else {
                stack.offerLast(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 检查是否成对
     *
     * @param s 源
     * @param t 目标
     * @return true：成对 false:不成对
     */
    private static boolean checkPair(char s, char t) {
        return (s == '{' && t == '}') || (s == '(' && t == ')') || (s == '[' && t == ']');
    }

}
