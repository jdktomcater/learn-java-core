package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

import java.util.Stack;

/**
 * 計算器
 */
public class Calculator {

    /**
     * 計算器
     *
     * @param source 表達式
     * @return 結果
     */
    public static int calculate(String source) {
        int num = 0;
        char pre = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == source.length() - 1) {
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
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default :

                }
                pre = ch;
                num = 0;
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String source = "3+2*2";
        System.out.println(calculate(source));
    }
}
