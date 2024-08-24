package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

/**
 * 战舰数量
 */
public class CountBattleShip {

    /**
     * 计算战舰数量
     *
     * @param board 船板信息
     * @return 战舰数量
     */
    public static int countBattleShips(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                // 判断是否为战舰
                if (board[i][j] == 'X') {
                    // 前位
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    // 上位
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
