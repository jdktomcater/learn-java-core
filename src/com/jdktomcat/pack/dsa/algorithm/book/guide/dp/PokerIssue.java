package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

/**
 * 纸牌博弈问题
 */
public class PokerIssue {

    /**
     * 纸牌游戏，先抓者最大牌值
     *
     * @param cards 牌信息
     * @return 最大牌值
     */
    public static int poker0(int[] cards) {
        if (cards == null || cards.length == 0) {
            return 0;
        }
        return Math.max(first(cards, 0, cards.length - 1), second(cards, 0, cards.length - 1));
    }

    /**
     * 先拿者最大牌值
     *
     * @param cards 牌信息
     * @param left  左索引
     * @param right 右索引
     * @return 最大牌值
     */
    private static int first(int[] cards, int left, int right) {
        if (left == right) {
            return cards[left];
        }
        return Math.max(cards[left] + second(cards, left + 1, right), cards[right] + second(cards, left, right - 1));
    }

    /**
     * 后拿者最大牌值
     *
     * @param cards 牌信息
     * @param left  左索引
     * @param right 右索引
     * @return 最大牌值
     */
    private static int second(int[] cards, int left, int right) {
        if (left == right) {
            return 0;
        }
        return Math.min(first(cards, left + 1, right), first(cards, left, right - 1));
    }

    /**
     * 纸牌游戏，先抓者最大牌值
     *
     * @param cards 牌信息
     * @return 最大牌值
     */
    public static int poker1(int[] cards) {
        if (cards == null || cards.length == 0) {
            return 0;
        }
        int[][] first = new int[cards.length][cards.length];
        int[][] second = new int[cards.length][cards.length];
        for (int j = 0; j < cards.length; j++) {
            first[j][j] = cards[j];
            for (int i = j - 1; i >= 0; i--) {
                first[i][j] = Math.max(cards[i] + second[i + 1][j], cards[j] + second[i][j - 1]);
                second[i][j] = Math.min(first[i + 1][j], first[i][j - 1]);
            }
        }
        return Math.max(first[0][cards.length - 1], second[0][cards.length - 1]);
    }

    public static void main(String[] args) {
        int[] cards = {1, 2, 100, 4};
        System.out.println(poker0(cards));
    }

}
