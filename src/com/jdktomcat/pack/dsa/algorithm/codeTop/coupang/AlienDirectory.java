package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.*;

/**
 * 外星字典
 */
public class AlienDirectory {

    /**
     * 现有一种使用英语字母的火星语言，这门语言的字母顺序与英语顺序不同。
     * 给你一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。
     * 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。
     * 若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。
     * 字符串 s 字典顺序小于 字符串 t 有两种情况：
     * 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。
     * 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。
     *
     * @param words 字符串数组
     * @return 字母排列顺序
     */
    public static String alienOrder(String[] words) {
        if (words.length == 1) {
            return words[0];
        }
        Map<Character, Integer> inputDegreeMap = new HashMap<>();
        Map<Character, Set<Character>> depMap = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                calMap(inputDegreeMap, depMap, words[i], words[j]);
            }
        }
        Queue<Character> queue = new LinkedList<>();
        inputDegreeMap.forEach((key, value) -> {
            if (value == 0) {
                queue.offer(key);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            stringBuilder.append(ch);
            inputDegreeMap.remove(ch);
            Set<Character> depSet = depMap.getOrDefault(ch, new HashSet<>());
            for (char dep : depSet) {
                int inputDegree = inputDegreeMap.get(dep) - 1;
                if (inputDegree == 0) {
                    queue.offer(dep);
                }
                inputDegreeMap.put(dep, inputDegree);
            }
        }
        return depMap.size() == stringBuilder.length() ? stringBuilder.reverse().toString() : "";
    }

    /**
     * 计算映射关系
     *
     * @param inputDegreeMap 入度信息
     * @param depMap         依赖信息
     * @param bigStr         大字符串
     * @param smallStr       小字符串
     */
    private static void calMap(Map<Character, Integer> inputDegreeMap, Map<Character, Set<Character>> depMap, String bigStr, String smallStr) {
        int bl = Math.max(bigStr.length(), smallStr.length());
        if (bigStr.startsWith(smallStr) && !bigStr.equals(smallStr)) {
            for (int i = 0; i < bl; i++) {
                depMap.putIfAbsent(bigStr.charAt(i), new HashSet<>());
            }
        } else {
            int sl = Math.min(bigStr.length(), smallStr.length());
            boolean flag = true;
            for (int i = 0; i < sl; i++) {
                char bc = bigStr.charAt(i);
                char sc = smallStr.charAt(i);
                if (bc != sc && flag) {
                    Set<Character> depSet = depMap.getOrDefault(sc, new HashSet<>());
                    if (depSet.add(bc)) {
                        depMap.put(sc, depSet);
                        inputDegreeMap.put(bc, inputDegreeMap.getOrDefault(bc, 0) + 1);
                    }
                    flag = false;
                }
                inputDegreeMap.putIfAbsent(sc, 0);
                inputDegreeMap.putIfAbsent(bc, 0);
                depMap.putIfAbsent(bc, new HashSet<>());
                depMap.putIfAbsent(sc, new HashSet<>());
            }
            String ls = bigStr.length() >= smallStr.length() ? bigStr : smallStr;
            for (int i = sl; i < bl; i++) {
                depMap.putIfAbsent(ls.charAt(i), new HashSet<>());
                inputDegreeMap.putIfAbsent(ls.charAt(i), 0);
            }
        }
    }

    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> indegrees = new HashMap<>();
    boolean valid = true;

    public String alienOrderL0(String[] words) {
        int length = words.length;
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                edges.putIfAbsent(c, new ArrayList<>());
            }
        }
        for (int i = 1; i < length && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }
        if (!valid) {
            return "";
        }
        Queue<Character> queue = new ArrayDeque<>();
        Set<Character> letterSet = edges.keySet();
        for (char u : letterSet) {
            if (!indegrees.containsKey(u)) {
                queue.offer(u);
            }
        }
        StringBuffer order = new StringBuffer();
        while (!queue.isEmpty()) {
            char u = queue.poll();
            order.append(u);
            List<Character> adjacent = edges.get(u);
            for (char v : adjacent) {
                indegrees.put(v, indegrees.get(v) - 1);
                if (indegrees.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }
        return order.length() == edges.size() ? order.toString() : "";
    }

    public void addEdge(String before, String after) {
        int length1 = before.length(), length2 = after.length();
        int length = Math.min(length1, length2);
        int index = 0;
        while (index < length) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                indegrees.put(c2, indegrees.getOrDefault(c2, 0) + 1);
                break;
            }
            index++;
        }
        if (index == length && length1 > length2) {
            valid = false;
        }
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienOrder(words));
    }
}
