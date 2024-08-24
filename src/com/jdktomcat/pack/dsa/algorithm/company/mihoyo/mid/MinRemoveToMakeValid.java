package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 移除无效括号
 */
public class MinRemoveToMakeValid {

    /**
     * 移除无效括号
     *
     * @param source 目标字符串
     * @return 移除后字符串
     */
    public static String minRemoveToMakeValidL0(String source) {
        StringBuilder result = removeInvalidClosing(source, '(', ')');
        result = removeInvalidClosing(result.reverse().toString(), ')', '(');
        return result.reverse().toString();
    }

    private static StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;
            }
            if (c == close) {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }

    public static String minRemoveToMakeValidL1(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String minRemoveToMakeValidL2(String source) {
        // Parse 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int openSeen = 0, balance = 0;
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            }
            if (c == ')') {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }

        // Parse 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) {
                    continue;
                }
            }
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String source = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValidL1(source));
    }

}
