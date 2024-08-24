package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.Stack;

/**
 * 字符串解码
 */
public class StringDecode {

    /**
     * 字符串解码
     *
     * @param target 目标字符串
     * @return 解码后字符串
     */
    public static String decodeString(String target) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < target.length()) {
            char ch = target.charAt(i);
            if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                String sub = sb.reverse().toString();
                stack.pop();
                StringBuilder dit = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    dit.append(stack.pop());
                }
                int num = Integer.parseInt(dit.reverse().toString());
                String repeat = repeat(num, sub);
                for (char subCh : repeat.toCharArray()) {
                    stack.push(subCh);
                }
            } else {
                stack.push(ch);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    /**
     * 重复追加字符串
     *
     * @param n      重复次数
     * @param target 目标字符串
     */
    private static String repeat(int n, String target) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < n; j++) {
            stringBuilder.append(target);
        }
        return stringBuilder.toString();
    }
}
