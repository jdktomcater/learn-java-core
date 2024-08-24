package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

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
     * @param intervals 区间数组
     * @return 合并后数组
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt((int[] it) -> it[0]));
        List<int[]> mergeIntervalList = new ArrayList<>();
        int[] targetInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= targetInterval[1]) {
                targetInterval[1] = Math.max(intervals[i][1], targetInterval[1]);
            } else {
                mergeIntervalList.add(targetInterval);
                targetInterval = intervals[i];
            }
        }
        mergeIntervalList.add(targetInterval);
        return mergeIntervalList.toArray(new int[mergeIntervalList.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergeIntervals = merge(intervals);
        for (int[] in : mergeIntervals) {
            System.out.println(Arrays.toString(in));
        }
    }
}
