package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

/**
 * 搜索矩阵
 */
public class SearchMatrix {

    /**
     * 搜索矩阵
     *
     * @param matrix 矩阵
     * @param target 目标值
     * @return 返回
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 矩阵长宽
        int m = matrix.length, n = matrix[0].length;
        // 高低指针
        int low = 0, high = m * n - 1;
        // 二分法查找
        while (low <= high) {
            // 中间值
            int mid = (high + low) >> 1;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
