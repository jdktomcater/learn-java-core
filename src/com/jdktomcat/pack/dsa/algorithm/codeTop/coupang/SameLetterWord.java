package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.*;

/**
 * 字母异位词分组
 */
public class SameLetterWord {

    /**
     * 字母异位词分组
     *
     * @param strings 字符串数组
     * @return 字母异位词分组
     */
    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> dataMap = new HashMap<>();
        for (String string : strings) {
            String anagram = anagram(string);
            List<String> sameAnagramList = dataMap.getOrDefault(anagram, new ArrayList<>());
            sameAnagramList.add(string);
            dataMap.put(anagram, sameAnagramList);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : dataMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    /**
     * @param target 目标字符
     * @return 统计标识
     */
    private static String anagram(String target) {
        if (target.length() == 0) {
            return "$$";
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : target.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Map.Entry<Character, Integer>[] entryArray = new Map.Entry[countMap.size()];
        countMap.entrySet().toArray(entryArray);
        Arrays.sort(entryArray, (e1, e2) -> {
            char ch1 = e1.getKey();
            char ch2 = e2.getKey();
            return ch1 - ch2;
        });
        for (Map.Entry<Character, Integer> entry : entryArray) {
            stringBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append("$");
        }
        return stringBuilder.toString();
    }

    /**
     * 字母异位词分组
     *
     * @param strings 字符串数组
     * @return 字母异位词分组
     */
    public static List<List<String>> groupAnagramsL0(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            // 数组计数
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] strings = {"chi", "nip", "lab", "mud", "fan", "yak", "kid", "lox", "joy", "rob", "cad", "hug", "ken", "oaf", "pus", "hos", "ton", "any", "sac", "mid", "nip", "ron", "tux", "set", "jug", "axe", "ago", "sob", "ode", "dot", "nit", "pug", "sue", "new", "rub", "sup", "ohs", "ski", "oaf", "don", "cob", "kin", "ark", "gay", "jay", "bur", "dot", "eat", "rca", "wad", "maj", "luz", "gad", "dam", "eon", "ark", "del", "sin", "tat"};
        List<List<String>> result = groupAnagrams(strings);
        for (List<String> anagrams : result) {
            System.out.println(Arrays.toString(anagrams.toArray()));
        }
    }

}
