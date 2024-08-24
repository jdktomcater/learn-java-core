package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 搜索二维矩阵 II
 */
public class MatrixSearch {

    /**
     * 搜索二维矩阵 II
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * <p>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int rl = 0, cr = col - 1, cs = 0, ce = row - 1, rmid = 0, cmid;
        while (rl <= cr && cs <= ce) {
            rmid = (rl + cr) >> 1;
            cmid = (cs + ce) >> 1;
            if (matrix[cmid][rmid] == target) {
                return true;
            } else if (matrix[cmid][rmid] < target) {
                rl = rmid + 1;
                cs = cmid + 1;
            } else {
                cr = rmid - 1;
                ce = cmid - 1;
            }
        }
        return false;
    }

    /**
     * 搜索二维矩阵 II
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * <p>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrixL0(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int rl = 0, cr = col - 1, cs = 0, ce = row - 1, rmid, cmid = 0;
        while (cs <= ce) {
            cmid = (cs + ce) >> 1;
            if (matrix[cmid][0] == target) {
                return true;
            } else if (matrix[cmid][0] < target) {
                cs = cmid + 1;
            } else {
                ce = cmid - 1;
            }
        }
        if (matrix[cmid][0] > target && cmid > 0) {
            cmid--;
        }
        while (rl <= cr) {
            rmid = (rl + cr) >> 1;
            if (matrix[cmid][rmid] == target) {
                return true;
            } else if (matrix[cmid][rmid] < target) {
                rl = rmid + 1;
            } else {
                cr = rmid - 1;
            }
        }
        return false;
    }


    /**
     * 搜索二维矩阵 II
     *
     * @param matrix 矩阵
     * @param target 目标值
     * @return true：存在 false：不存在
     */
    public static boolean searchMatrixL1(int[][] matrix, int target) {
        boolean[] result = {false};
        dfs(matrix, target, 0, 0, result);
        return result[0];
    }

    /**
     * 深度遍历逻辑
     *
     * @param matrix 矩阵
     * @param target 目标值
     * @param i      横坐标
     * @param j      竖坐标
     * @param result 结果值
     */
    private static void dfs(int[][] matrix, int target, int i, int j, boolean[] result) {
        if (result[0]) {
            return;
        }
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                result[0] = true;
            } else if (matrix[i][j] < target) {
                dfs(matrix, target, i + 1, j, result);
                dfs(matrix, target, i, j + 1, result);
            } else {
                dfs(matrix, target, i - 1, j, result);
                dfs(matrix, target, i, j - 1, result);
            }
        }
    }

    /**
     * 查找
     *
     * @param matrix 矩阵
     * @param target 目标值
     * @return true：有 false：否
     */
    public static boolean searchMatrixL5(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = binSearch(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     *
     * @param numbers 数组
     * @param target  目标
     * @return 目标索引
     */
    public static int binSearch(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low <= high) {
            int mid = (high + low) >> 1;
            int num = numbers[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * z字形查找
     * 先从左下角开始遍历
     *
     * @param matrix 矩阵
     * @param target 目标
     * @return true：有 false：否
     */
    public static boolean searchMatrixL6(int[][] matrix, int target) {
        // 坐标
        int x = 0, y = matrix[0].length - 1;
        // 边界
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{2,3}};
        int target1 = 2;
        System.out.println(searchMatrixL6(matrix1, target1));
        int[][] matrix2 = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target2 = 5;
        System.out.println(searchMatrixL6(matrix2, target2));
        int[][] matrix3 = {{1, 4}, {2, 5}};
        int target3 = 2;
        System.out.println(searchMatrixL6(matrix3, target3));
        int[][] matrix4 = {{-5}};
        int target4 = -10;
        System.out.println(searchMatrixL6(matrix4, target4));
        int[][] matrix5 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int target5 = 19;
        System.out.println(searchMatrixL6(matrix5, target5));
    }

}
