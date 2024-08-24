package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 颠倒字符串中的单词
 */
public class ReverseWord {

    /**
     * 颠倒字符串中的单词
     *
     * @param target 目标字符串
     * @return 颠倒字符串中的单词
     */
    public static String reverseWords(String target) {
        String[] words = target.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
    }

}
