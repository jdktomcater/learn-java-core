package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd;

/**
 * 查找乘法表中第k小的数
 */
public class FindKthNumber {

    /**
     * 查找乘法表中第k小的数（二分法）
     *
     * @param m 横
     * @param n 列
     * @param k 阈值
     * @return 目标数
     */
    public static int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = (right + left) / 2;
            int cnt = 0;
            for (int i = 1; i <= m; i++) {
                // mid/i表示mid所处行数，大于n的话，说明目标值本行下面，该行所有值均在其前，统计
                cnt += Math.min(n, mid / i);
            }
            // 统计值大于等于k的话，说明统计多了，需要减少搜索范围
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findKthNumberL0(int m, int n, int k) {
        int left = 1, right = m * n + 1;
        while (left < right) {
            int mid = (right + left) >> 1;
            if (getRanking(mid, m, n) >= k) {
                // mid的名次大于等于k，说明mid选大了，将right缩小
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int getRanking(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count;
    }


    /**
     * 查找乘法表中第k小的数（二分法）
     *
     * @param m 横
     * @param n 列
     * @param k 阈值
     * @return 目标数
     */
    public static int findKthNumberL1(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = (right + left) >> 1;
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(n, mid / i);
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}
