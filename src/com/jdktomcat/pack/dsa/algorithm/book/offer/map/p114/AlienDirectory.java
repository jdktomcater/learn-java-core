package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p114;

import java.util.*;

/**
 * 外星文字典
 */
public class AlienDirectory {

    /**
     * 计算外星文排序
     *
     * @param words 单词列表
     * @return 排序
     */
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                inDegree.putIfAbsent(ch, 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            if (w1.startsWith(w2) && !w1.equals(w2)) {
                return "";
            }
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        inDegree.put(ch2, inDegree.get(ch2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char ch : inDegree.keySet()) {
            if (inDegree.get(ch) == 0) {
                queue.add(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.remove();
            stringBuilder.append(ch);
            for (char next : graph.get(ch)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return stringBuilder.length() == graph.size() ? stringBuilder.toString() : "";
    }

    public static void main(String[] args) {
        String[] words = new String[]{"ac", "ab", "bc", "zc", "zb"};
        System.out.println(alienOrder(words));
    }

}
