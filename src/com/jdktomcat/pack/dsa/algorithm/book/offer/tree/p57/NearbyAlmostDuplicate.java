package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p57;

import java.util.TreeSet;

/**
 * 值和小标之差都在给定的范围内
 */
public class NearbyAlmostDuplicate {

    /**
     * 判断值和小标之差是否都在给定的范围内
     *
     * @param numbers 目标数组
     * @param k       值差
     * @param t       索引差
     * @return true：是 false：否
     */
    public static boolean containsNearbyAlmostDuplicate(int[] numbers, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            Long lower = set.floor((long) numbers[i]);
            if (lower != null && lower >= (long) numbers[i] - t) {
                return true;
            }
            Long upper = set.ceiling((long) numbers[i]);
            if (upper != null && upper <= (long) numbers[i] - t) {
                return true;
            }
            set.add((long) numbers[i]);
            if (i >= k) {
                set.remove((long) numbers[i - k]);
            }
        }
        return false;
    }
}
