package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class SearchMatrixWord {

    /**
     * 单词搜索
     *
     * @param board 矩阵数组信息
     * @param word  单词
     * @return true:存在 false:不存在
     */
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[] result = {false};
                    dfs(board, word, i, j, new boolean[board.length][board[0].length], 0, result);
                    if (result[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 深度计算逻辑
     *
     * @param board   矩阵数组信息
     * @param word    单词
     * @param i       横坐标
     * @param j       竖坐标
     * @param visited 访问状态记录
     * @param index   索引
     * @param result  结果
     */
    private static void dfs(char[][] board, String word, int i, int j, boolean[][] visited, int index, boolean[] result) {
        if (result[0] || !(i >= 0 && i < board.length && j >= 0 && j < board[0].length) || visited[i][j]) {
            return;
        }
        if (index == word.length() - 1 && board[i][j] == word.charAt(index)) {
            result[0] = true;
        } else if (index < word.length() - 1 && board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            dfs(board, word, i + 1, j, visited, index + 1, result);
            dfs(board, word, i - 1, j, visited, index + 1, result);
            dfs(board, word, i, j + 1, visited, index + 1, result);
            dfs(board, word, i, j - 1, visited, index + 1, result);
            if (!result[0]) {
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
    }
}
