package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p72;

/**
 * 求平方根
 */
public class Sqrt {

    /**
     * 计算平方根
     *
     * @param target 目标值
     * @return 平方根
     */
    public static int sqrt(int target) {
        int left = 1;
        int right = target;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid <= target / mid) {
                if ((mid + 1) > target / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
