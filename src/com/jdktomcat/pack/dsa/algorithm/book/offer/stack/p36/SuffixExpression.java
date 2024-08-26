package com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p36;

import java.util.Stack;

/**
 * 后缀表达式
 */
public class SuffixExpression {

    /**
     * 计算表达式
     *
     * @param tokens 表达式
     * @return 计算结果
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(calculate(num1, num2, token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    /**
     * 计算
     *
     * @param num1    值1
     * @param num2    值2
     * @param operate 操作符
     * @return 结果
     */
    public static int calculate(int num1, int num2, String operate) {
        switch (operate) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
