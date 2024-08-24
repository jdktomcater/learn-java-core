package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器
 */
public class BasicCalculator {

    public static int calculate(String expression) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1, ret = 0, n = expression.length(), i = 0;
        while (i < n) {
            if (expression.charAt(i) == ' ') {
                i++;
            } else if (expression.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (expression.charAt(i) == '-') {
                sign = -ops.peek();
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

}
