package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 计算器
 */
public class Calculator {

    /**
     * 计算器
     *
     * @param expression 表达式
     * @return 计算结果
     */
    public static int calculate(String expression) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;
        int ret = 0;
        int n = expression.length();
        int i = 0;
        while (i < n) {
            if (expression.charAt(i) == ' ') {
                i++;
            } else if (expression.charAt(i) == '+') {
                sign = !ops.isEmpty() ? ops.peek() : 0;
                i++;
            } else if (expression.charAt(i) == '-') {
                sign = !ops.isEmpty() ? -ops.peek() : 0;
                i++;
            } else if (expression.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (expression.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    /**
     * 计算器
     *
     * @param expression 表达式
     * @return 计算结果
     */
    public static int calculateL0(String expression) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = expression.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(expression.charAt(i))) {
                num = num * 10 + expression.charAt(i) - '0';
            }
            if (!Character.isDigit(expression.charAt(i)) && expression.charAt(i) != ' ' || i == n - 1) {
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
                preSign = expression.charAt(i);
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
     * 获取数字
     *
     * @param expression 表达式
     * @param start      开始索引
     * @return 数字
     */
    private static int[] getNum(String expression, int start) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = start;
        while (i++ < expression.length() && Character.isDigit(expression.charAt(i))) {
            stringBuilder.append(expression.charAt(i));
        }
        return new int[]{Integer.parseInt(stringBuilder.toString()), i};
    }
}
