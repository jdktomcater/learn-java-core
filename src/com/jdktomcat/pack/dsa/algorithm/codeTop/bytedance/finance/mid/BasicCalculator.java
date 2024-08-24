package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器 II
 */
public class BasicCalculator {

    /**
     * 基本计算器
     *
     * @param expression 表达式
     * @return 结果
     */
    public static int calculate(String expression) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        int pre = '+';
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == expression.length() - 1) {
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
