package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p71;

import java.util.Random;

/**
 * 按权重生成随机数
 */
public class GenerateRandomByWeight {

    private int[] sums;

    private int total;

    public GenerateRandomByWeight(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int p = random.nextInt(total);
        int left = 0;
        int right = sums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sums[mid] > p) {
                if (mid == 0 || (sums[mid - 1] <= p)) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
