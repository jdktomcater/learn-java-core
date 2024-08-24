package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 最大正方形
 */
public class MaxSquare {

    /**
     * 最大正方形
     *
     * @param matrix 矩阵
     * @return 最大正方形面积
     */
    public static int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, dfs(matrix, i, j));
                }
            }
        }
        return max;
    }

    /**
     * 深度遍历计算返回最大正方形大小
     *
     * @param matrix 矩阵
     * @param i      行
     * @param j      列
     * @return 深度遍历计算返回最大正方形大小
     */
    private static int dfs(char[][] matrix, int i, int j) {
        int edge = 1;
        while (i < matrix.length && j < matrix[0].length && isSquare(matrix, i, j, edge)) {
            edge++;
        }
        return edge * edge;
    }

    /**
     * 是否是正方形
     *
     * @param matrix 矩阵
     * @param i      行坐标
     * @param j      列坐标
     * @param edge   长度
     * @return true：是 false：否
     */
    private static boolean isSquare(char[][] matrix, int i, int j, int edge) {
        if (i + edge >= matrix.length || j + edge >= matrix[0].length) {
            return false;
        }
        for (int nr = 0; nr <= edge && nr + i < matrix.length; nr++) {
            for (int nc = 0; nc <= edge && nc + j < matrix[0].length; nc++) {
                if (matrix[nr + i][nc + j] != '1') {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 最大正方形
     *
     * 如果该位置的值是 00，则 \textit{dp}(i, j) = 0dp(i,j)=0，因为当前位置不可能在由 11 组成的正方形中；
     *
     * 如果该位置的值是 11，则 \textit{dp}(i, j)dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 \textit{dp}dp 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 11，状态转移方程如下：
     *
     * dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
     *
     * 此外，还需要考虑边界条件。如果 ii 和 jj 中至少有一个为 00，则以位置 (i, j)(i,j) 为右下角的最大正方形的边长只能是 11，因此 \textit{dp}(i, j) = 1dp(i,j)=1。
     *
     *
     * @param matrix 矩阵
     * @return 最大正方形面积
     */
    public static int maximalSquareL0(char[][] matrix){
        // 最大边
        int maxSide = 0;
        // 判断矩阵是否为空
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        // 运行缓存：dp[i][j]标识表示以 (i, j)(i,j) 为右下角，且只包含 11 的正方形的边长最大值
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 判断是否为1
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 初始
                        dp[i][j] = 1;
                    } else {
                        // 最小值+1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }



    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        char[][] matrix = {{'0', '0', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}};
        System.out.println(maximalSquare(matrix));
    }
}
