package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRpn {

    /**
     * 逆波兰表达式求值
     *
     * @param tokens 数组
     * @return 逆波兰表达式求值
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token){
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private static boolean isNumber(String token) {
        return !"+".equals(token) && !"-".equals(token) && !"*".equals(token) && !"/".equals(token);
    }

}
