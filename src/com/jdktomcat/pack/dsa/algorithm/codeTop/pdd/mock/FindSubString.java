package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd.mock;

import java.util.*;

public class FindSubString {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        dfs(words, 0, set);
        for (String cob : set) {
            int index = s.indexOf(cob, 0);
            while (index != -1) {
                res.add(index);
                index = s.indexOf(cob, index + 1);
            }
        }
        return res;
    }

    private static void dfs(String[] words, int index, Set<String> set) {
        if (index == words.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : words) {
                stringBuilder.append(word);
            }
            set.add(stringBuilder.toString());
        } else {
            for (int i = index; i < words.length; i++) {
                swap(words, index, i);
                dfs(words, index + 1, set);
                swap(words, index, i);
            }
        }
    }

    private static void swap(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    public static List<Integer> findSubstringL0(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    private static void dfsAll(String s, String[] words, StringBuilder target, int i, int j, List<Integer> res) {
        if (j == words.length) {
            res.add(i);
        }else {
            target.append(words[j+1]);
        }
    }

}
