package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 单词搜索
 */
public class MatrixSearchWord {

    /**
     * 单词搜索
     *
     * @param board 字符数组
     * @param word  目标单词
     * @return true：是 false：否
     */
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.indexOf(board[i][j]) == 0) {
                    boolean[] result = {false};
                    boolean[][] dp = new boolean[board.length][board[0].length];
                    findWord(board, dp, word, 0, i, j, result);
                    if (result[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 单词查找
     *
     * @param board  字符数组
     * @param dp     状态缓存（true：已遍历 false：未遍历）
     * @param word   单词
     * @param index  索引
     * @param i      横坐标
     * @param j      竖坐标
     * @param result 查找结果
     */
    private static void findWord(char[][] board, boolean[][] dp, String word, int index, int i, int j, boolean[] result) {
        if (result[0] || !(i >= 0 && i < board.length && j >= 0 && j < board[0].length) || dp[i][j]) {
            return;
        }
        if (index == word.length() - 1 && board[i][j] == word.charAt(index)) {
            result[0] = true;
        } else if (index < word.length() - 1 && board[i][j] == word.charAt(index)) {
            dp[i][j] = true;
            findWord(board, dp, word, index + 1, i - 1, j, result);
            findWord(board, dp, word, index + 1, i, j - 1, result);
            findWord(board, dp, word, index + 1, i + 1, j, result);
            findWord(board, dp, word, index + 1, i, j + 1, result);
            if (!result[0]) {
                dp[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        System.out.println(exist(board, word1));
        String word2 = "SEE";
        System.out.println(exist(board, word2));
        String word3 = "ABCB";
        System.out.println(exist(board, word3));
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word4 = "ABCESEEEFS";
        System.out.println(exist(board1, word4));
    }
}
