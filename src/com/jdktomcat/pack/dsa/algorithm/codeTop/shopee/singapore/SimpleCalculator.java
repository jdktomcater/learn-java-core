package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 简单计算器
 */
public class SimpleCalculator {

    /**
     * 简单计算器
     *
     * @param s 表达式
     * @return 计算结果
     */
    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }


    /**
     * 简单计算器
     *
     * @param expression 表达式
     * @return 计算结果
     */
    public static int calculateL0(String expression) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        int pre = '+';
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (!Character.isDigit(ch) && ch != ' ' || i == expression.length() - 1) {
                switch (pre) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                pre = ch;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
