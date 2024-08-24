package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

import java.util.List;

/**
 * 凸多边形
 */
public class ConvexIssue {

    /**
     * 判断是否为凸多边形
     *
     * @param points 点信息
     * @return true：是 false：否
     */
    public static boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long cur, pre = 0;
        for (int i = 0; i < n; i++) {
            cur = crossProduct(points.get((i + 1) % n).get(0) - points.get(i).get(0),
                    points.get((i + 1) % n).get(1) - points.get(i).get(1),
                    points.get((i + 2) % n).get(0) - points.get(i).get(0),
                    points.get((i + 2) % n).get(1) - points.get(i).get(1));
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                }
                pre = cur;
            }
        }
        return true;
    }

    /**
     * 交叉乘积
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    private static long crossProduct(long x1, long y1, long x2, long y2) {
        return x1 * y2 - x2 * y1;
    }
}
