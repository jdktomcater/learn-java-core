package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 */
public class MinCoverSubString {

    /**
     * 最小覆盖子串
     *
     * @param s 长字符串
     * @param t 短字符串
     * @return 最小覆盖子串
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> dataMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            dataMap.put(ch, dataMap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> dataMapTemp = new HashMap<>();
        int leftIndex = -1;
        int[] min = {-1, 0, Integer.MAX_VALUE};
        dfs(s, t, leftIndex, 0, min, dataMap, dataMapTemp);
        return min[0] != -1 ? s.substring(min[0], min[1]) : "";
    }

    /**
     * 深度遍历处理逻辑
     *
     * @param target      目标字符串
     * @param leftIndex   左索引
     * @param min         最大值
     * @param dataMap     目标字符映射
     * @param dataMapTemp 备份字符映射
     */
    public static void dfs(String target, String dist, int leftIndex, int index, int[] min, Map<Character, Integer> dataMap, Map<Character, Integer> dataMapTemp) {
        if (leftIndex >= index || index >= target.length()) {
            return;
        }
        char ch = target.charAt(index);
        if (dataMap.containsKey(ch)) {
            if (leftIndex == -1) {
                leftIndex = index;
            }
            transfer(dataMap, dataMapTemp, ch);
            if (dataMap.size() == 0) {
                if (min[2] > index - leftIndex + 1) {
                    min[2] = index - leftIndex + 1;
                    min[1] = index + 1;
                    min[0] = leftIndex;
                }
                transfer(dataMapTemp, dataMap, target.charAt(leftIndex));
                dfs(target, dist, moveLeft(target, dist, leftIndex, index, dataMap, dataMapTemp), index + 1, min, dataMap, dataMapTemp);
            } else {
                dfs(target, dist, leftIndex, index + 1, min, dataMap, dataMapTemp);
            }
        } else if (dataMapTemp.containsKey(ch) && target.charAt(leftIndex) == ch) {
            dfs(target, dist, moveLeft(target, dist, leftIndex, index, dataMap, dataMapTemp), index + 1, min, dataMap, dataMapTemp);
        } else {
            dfs(target, dist, leftIndex, index + 1, min, dataMap, dataMapTemp);
        }
    }

    /**
     * 计算下一步索引位置
     *
     * @param target    目标字符串
     * @param dist      映射
     * @param leftIndex 左索引
     * @return 下一步索引
     */
    private static int moveLeft(String target, String dist, int leftIndex, int index, Map<Character, Integer> dataMap, Map<Character, Integer> dataMapTemp) {
        for (int i = leftIndex + 1; i <= index; i++) {
            if (dist.indexOf(target.charAt(i)) != -1) {
                char ch = target.charAt(i);
                boolean subEqual = false;
                for (int j = i + 1; j <= index && !subEqual; j++) {
                    if (target.charAt(j) == ch) {
                        subEqual = true;
                    }
                }
                if (!subEqual) {
                    return i;
                } else {
                    transfer(dataMapTemp, dataMap, ch);
                }
            }
        }
        return -1;
    }


    public static String minWindowL0(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> dataMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            dataMap.put(ch, dataMap.getOrDefault(ch, 0) + 1);
        }
        int leftIndex = 0, rightIndex = 0;
        int[] max = {-1, s.length()};
        while (rightIndex < s.length()) {
            char ch = s.charAt(rightIndex);
            if (dataMap.containsKey(ch) && check(s, leftIndex, rightIndex, dataMap)) {
                max(max, leftIndex, rightIndex);
                leftIndex++;
            } else {
                rightIndex++;
            }
        }
        return max[0] == -1 ? "" : s.substring(max[0], max[1]);
    }

    private static void max(int[] max, int left, int right) {
        if (max[1] - max[0] > right - left + 1) {
            max[1] = right + 1;
            max[0] = left;
        }
    }

    /**
     * 判断是否是覆盖
     *
     * @param target  目标字符串
     * @param start   开始索引
     * @param end     结束索引
     * @param dataMap 目标字符计数
     * @return true：覆盖 false：不覆盖
     */
    private static boolean check(String target, int start, int end, Map<Character, Integer> dataMap) {
        Map<Character, Integer> map = new HashMap<>();
        for (int index = start; index <= end; index++) {
            char ch = target.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : dataMap.entrySet()) {
            if (entry.getValue() > map.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 转移字符
     *
     * @param source 源集合
     * @param dist   目的集合
     * @param target 目标字符
     */
    private static void transfer(Map<Character, Integer> source, Map<Character, Integer> dist, char target) {
        if (source.containsKey(target)) {
            int count = source.get(target);
            if (count == 1) {
                source.remove(target);
            } else {
                source.put(target, count - 1);
            }
            dist.put(target, dist.getOrDefault(target, 0) + 1);
        }
    }

    /**
     * 最小覆盖子串
     *
     * @param s 长字符串
     * @param t 短字符串
     * @return 最小覆盖子串
     */
    public static String minWindowL1(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;
        int[] hash = new int[128];
        for (char ch : chart) hash[ch]--;

        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) cnt++;
            while (cnt == m && hash[chars[j]] > 0) hash[chars[j++]]--;
            if (cnt == m) if (res.equals("") || res.length() > i - j + 1) res = s.substring(j, i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(minWindowL1(s1, t1));
        String s2 = "bdab";
        String t2 = "ab";
        System.out.println(minWindowL1(s2, t2));
        String s3 = "acbbaca";
        String t3 = "aba";
        System.out.println(minWindowL1(s3, t3));
        String s4 = "a";
        String t4 = "a";
        System.out.println(minWindowL1(s4, t4));
        String s5 = "cabefgecdaecf";
        String t5 = "cae";
        System.out.println(minWindowL1(s5, t5));

        String s6 = "aaflslflsldkalskaaa";
        String t6 = "aaa";
        System.out.println(minWindowL1(s6, t6));
    }
}
