package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p35;

import java.util.List;

/**
 * 最小时间差
 */
public class MinTimeDifference {

    /**
     * 最小时间差
     *
     * @param timePoints 时间点
     * @return 最小时间差
     */
    public static int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        boolean[] minuteFlags = new boolean[1440];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int min = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if (minuteFlags[min]) {
                return 0;
            }
            minuteFlags[min] = true;
        }
        return helper(minuteFlags);
    }

    /**
     * 最小时间差
     *
     * @param minuteFlags 标识
     * @return 最小时间差
     */
    private static int helper(boolean[] minuteFlags) {
        int minDiff = minuteFlags.length - 1;
        int prev = -1;
        int first = minuteFlags.length - 1;
        int last = -1;
        for (int i = 0; i < minuteFlags.length; i++) {
            if (minuteFlags[i]) {
                if (prev >= 0) {
                    minDiff = Math.min(i - prev, minDiff);
                }
                prev = i;
                first = Math.min(i, first);
                last = Math.max(i, last);
            }
        }
        minDiff = Math.min(first + minuteFlags.length - last, minDiff);
        return minDiff;
    }
}
