package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p119;

import java.util.*;

/**
 * 最长连续序列
 */
public class LongestConsecutiveSequence {

    /**
     * 最长连续序列长度
     *
     * @param numbers 数组
     * @return 长度
     */
    public static int longestConsecutive(int[] numbers) {
        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        for (int num : numbers) {
            fathers.put(num, num);
            counts.put(num, 1);
            all.add(num);
        }
        for (int num : numbers) {
            if (all.contains(num + 1)) {
                union(fathers, counts, num, num + 1);
            }
            if (all.contains(num - 1)) {
                union(fathers, counts, num, num - 1);
            }
        }
        int longest = 0;
        for (int length : counts.values()) {
            longest = Math.max(longest, length);
        }
        return longest;
    }

    /**
     * 查找父节点
     *
     * @param fathers 父节点映射关系
     * @param i       目标节点
     * @return 父根节点
     */
    private static int findFather(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            return findFather(fathers, fathers.get(i));
        }
        return fathers.get(i);
    }

    /**
     * 合并集连接
     *
     * @param fathers 父映射集合
     * @param counts  计数集合
     * @param i       目标1
     * @param j       目标2
     */
    private static void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fatherOfI != fatherOfJ) {
            fathers.put(fatherOfI, fatherOfJ);
            counts.put(j, counts.get(fatherOfJ) + counts.get(fatherOfI));
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{10, 5, 9, 2, 4, 3, 7, 6,8};
        System.out.println(longestConsecutive(numbers));
    }
}
