package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p73;

import java.util.Arrays;

/**
 * 狒狒吃香蕉
 */
public class MinEatingSpeed {

    /**
     * 狒狒吃香蕉
     *
     * @param piles 香蕉数
     * @param h     间隔
     * @return 吃香蕉数
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            int hours = getHours(piles, mid);
            if (hours <= h) {
                if (mid == 1 || getHours(piles, mid - 1) > h) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 计算消耗时间
     *
     * @param piles 香蕉数
     * @param speed 速度
     * @return 消耗时间
     */
    private static int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
}
