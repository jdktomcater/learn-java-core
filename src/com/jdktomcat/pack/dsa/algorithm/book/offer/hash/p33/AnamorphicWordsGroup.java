package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p33;

import java.util.*;

/**
 * 变位词组
 */
public class AnamorphicWordsGroup {

    /**
     * 变位词组
     *
     * @param strings 目标字符串
     * @return 变位词组
     */
    public static List<List<String>> groupAnagrams(String[] strings) {
        int[] hash = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> groups = new HashMap<>();
        for (String str : strings) {
            long sum = 1L;
            for (char ch : str.toCharArray()) {
                sum *= hash[ch - 'a'];
            }
            List<String> groupList = groups.getOrDefault(sum, new ArrayList<>());
            groupList.add(str);
            groups.put(sum, groupList);
        }
        return new ArrayList<>(groups.values());
    }

    /**
     * 变位词组
     *
     * @param strings 目标字符串
     * @return 变位词组
     */
    public static List<List<String>> groupAnagramsSort(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strings) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> groupList = groups.getOrDefault(sorted, new ArrayList<>());
            groupList.add(str);
            groups.put(sorted, groupList);
        }
        return new ArrayList<>(groups.values());
    }
}
