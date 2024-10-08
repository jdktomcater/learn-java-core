package com.jdktomcat.pack.dsa.algorithm.book.offer.array.p5;


/**
 * 单词长度最大乘积
 * 输入一个字符串数组words，请计算当两个字符串words[i]和words[j]不包含相同字符时它们长度的乘积的最大值。
 * 如果没有不包含相同字符的一对字符串，那么返回0。假设字符串中只包含英语的小写字母。例如，输入的字符串数组words为
 * ["abcw", "foo", "bar", "fxyz","abcdef"]，数组中的字符串"bar"与"foo"没有相同的字符，它们长度的乘积为9。
 * "abcw"与" fxyz "也没有相同的字符，它们长度的乘积是16，这是不含相同字符的一对字符串的长度乘积的最大值。
 */
public class MaxWordLengthProduct {

    /**
     * 最大乘积
     *
     * @param words 单词数组
     * @return 最大乘积
     */
    public static int maxProduct(String[] words) {
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for(char c: words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arrays  = {"abcw", "foo", "bar", "fxyz","abcdef"};
        System.out.println(maxProduct(arrays));
    }

}
