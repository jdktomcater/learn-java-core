package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Stack;

/**
 * 有效括号
 */
public class EffectiveBracket {


    /**
     * 校验括号是否有效
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * @param bracket 括号组成的字符串
     * @return true：有效 false：无效
     */
    public static boolean checkBracket(String bracket) {
        if (bracket.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : bracket.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                Character top = stack.peek();
                if (checkPair(ch, top)) {
                    stack.pop();
                } else if (ch == ')' || ch == '}' || ch == ']') {
                    return false;
                } else if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 校验是否成对
     *
     * @param ch  字符
     * @param pop 栈顶元素
     * @return true：成对 false：不成对
     */
    private static boolean checkPair(char ch, char pop) {
        if (ch == ')') {
            return pop == '(';
        }
        if (ch == '}') {
            return pop == '{';
        }
        if (ch == ']') {
            return pop == '[';
        }
        return false;
    }

    public static void main(String[] args) {
        String bracket = "()[]{}";
        System.out.println(checkBracket(bracket));
    }
}
