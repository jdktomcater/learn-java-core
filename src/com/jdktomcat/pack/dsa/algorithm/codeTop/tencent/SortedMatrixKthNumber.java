package com.jdktomcat.pack.dsa.algorithm.codeTop.tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class SortedMatrixKthNumber {

    /**
     * 有序矩阵第k小元素（暴力破解）
     *
     * @param matrix 矩阵
     * @param k      目标元素
     * @return 目标元素
     */
    public static int kthSmallest0(int[][] matrix, int k) {
        int n = matrix.length, index = 0;
        int[] numbers = new int[n * n];
        for (int[] ints : matrix) {
            for (int num : ints) {
                numbers[index++] = num;
            }
        }
        Arrays.sort(numbers);
        return numbers[k - 1];
    }

    /**
     * 有序矩阵第k小元素（最小堆）
     *
     * @param matrix 矩阵
     * @param k      目标元素
     * @return 目标元素
     */
    public static int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length, index = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = minHeap.poll();
            if (now[2] != n - 1) {
                minHeap.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return Objects.requireNonNull(minHeap.poll())[0];
    }

    /**
     * 有序矩阵第k小元素（二分法）
     *
     * @param matrix 矩阵
     * @param k      目标元素
     * @return 目标元素
     */
    public static int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (right + left) >> 1;
            if (check(matrix, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 检查是否已经达到了k
     *
     * @param matrix 矩阵
     * @param mid    中间点
     * @param k      目标数据
     * @return 目标数据
     */
    public static boolean check(int[][] matrix, int mid, int k) {
        int i = matrix.length - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest2(matrix, k));
    }
}
