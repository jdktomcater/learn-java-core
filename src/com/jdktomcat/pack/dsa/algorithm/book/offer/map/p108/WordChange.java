package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p108;

import java.util.*;

/**
 * 单词演变
 * <p>
 * Q:输入两个长度相同但内容不同的单词和一个单词列表，求演变的最短长度
 */
public class WordChange {

    /**
     * 获取相关单词列表
     *
     * @param word 单词
     * @return 相关单词列表
     */
    public static List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != old) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }

    /**
     * 计算转换步骤
     *
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  单词列表
     * @return 转换步骤
     */
    public static int changeStep(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> notVisited = new HashSet<>(wordList);
        queue1.add(beginWord);
        int length = 1;
        while (!queue1.isEmpty()) {
            String word = queue1.remove();
            if (word.equals(endWord)) {
                return length;
            }
            List<String> neighbors = getNeighbors(word);
            for (String neighbor : neighbors) {
                if (notVisited.contains(neighbor)) {
                    queue2.add(neighbor);
                    notVisited.remove(neighbor);
                }
            }
            if (queue1.isEmpty()) {
                length++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        int step = changeStep(beginWord, endWord, Arrays.asList(wordArray));
        System.out.println("最少转化步骤：" + step);
    }
}
