package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 */
public class MergeIntervals {

    /**
     * 合并区间
     *
     * @param intervals 区间
     * @return 合并后区间
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> mergeIntervalList = new ArrayList<>();
        mergeIntervalList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] preInts = mergeIntervalList.get(mergeIntervalList.size() - 1);
            int[] ints = intervals[i];
            if (preInts[1] < ints[0]) {
                mergeIntervalList.add(ints);
            } else {
                preInts[1] = Math.max(ints[1], preInts[1]);
            }
        }
        return mergeIntervalList.toArray(new int[mergeIntervalList.size()][]);
    }

}
