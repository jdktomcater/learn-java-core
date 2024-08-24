package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.easy;

/**
 * 删除相邻字符串
 */
public class RemoveDuplicates {
    /**
     * 删除相邻字符
     *
     * @param target 目标字符串
     * @return 结果
     */
    public static String removeDuplicates(String target) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < target.length(); ++i) {
            char ch = target.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        String target = "aaaaaaaaa";
        System.out.println(removeDuplicates(target));
    }

}
