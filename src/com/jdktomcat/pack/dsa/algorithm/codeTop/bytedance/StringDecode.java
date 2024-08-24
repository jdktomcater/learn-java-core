package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

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
    public static String decodeStringL0(String target) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0, il = 0, idl = 0, idr = 0;
        boolean in = false;
        while (i < target.length()) {
            char ch = target.charAt(i);
            if (Character.isDigit(ch)) {
                idl = i;
            } else if (ch == '[') {
                in = true;
                il = i + 1;
                idr = i;
            } else if (ch == ']') {
                int num = Integer.parseInt(target.substring(idl, idr));
                String subTarget = target.substring(il, i);
                for (int j = 0; j < num; j++) {
                    stringBuilder.append(subTarget);
                }
                in = false;
            } else {
                if (!in) {
                    stringBuilder.append(ch);
                }
            }
            i++;
        }
        return stringBuilder.toString();
    }

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

    public static void main(String[] args) {
        String target = "3[a]2[bc]";
        System.out.println(decodeString(target));
    }

}
