package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p34;

/**
 * 外星语言是否排序
 */
public class AlienWord {

    /**
     * 外星语言是否排序
     *
     * @param words 单词组
     * @param order 顺序
     * @return true：是 false：否
     */
    public static boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderArray)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否是否是排序的
     *
     * @param word1 单词1
     * @param word2 单词2
     * @param order 顺序
     * @return true：是 false：否
     */
    private static boolean isSorted(String word1, String word2, int[] order) {
        int i = 0;
        for (; i < word1.length() && i < word2.length(); i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if (order[ch1 - 'a'] < order[ch2 - 'a']) {
                return true;
            }
            if (order[ch1 - 'a'] > order[ch2 - 'a']) {
                return false;
            }
        }
        return i == word1.length();
    }
}
