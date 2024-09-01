package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p74;

import org.junit.Test;

import java.util.Arrays;

public class MergeIntervalTest {

    @Test
    public void merge() {
        int[][] intervals = {{1, 3}, {4, 5}, {8, 10}, {2, 6}, {9, 12}, {15, 18}};
        int[][] result = MergeInterval.merge(intervals);
        for (int[] array : result) {
            System.out.println(Arrays.toString(array));
        }
    }
}