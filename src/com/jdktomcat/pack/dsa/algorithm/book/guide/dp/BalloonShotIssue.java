package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

/**
 * 气球射击相关问题
 */
public class BalloonShotIssue {
    /**
     * 射击气球
     *
     * @param scores 分数数组
     * @param left   左索引
     * @param right  右索引
     * @return 得分
     */
    private static int shoot(int[] scores, int left, int right) {
        if (left == right) {
            return scores[left - 1] * scores[left] * scores[right + 1];
        }
        int max = Math.max(
                scores[left - 1] * scores[left] * scores[right + 1] + shoot(scores, left + 1, right),
                scores[left - 1] * scores[right] * scores[right + 1] + shoot(scores, left, right - 1)
        );
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, scores[left - 1] * scores[i] * scores[right + 1] + shoot(scores, left, i - 1) + shoot(scores, i + 1, right));
        }
        return max;
    }

    /**
     * 最大分数（递归深度回溯）
     *
     * @param scores 分数数组
     * @return 最大分数
     */
    public static int maxScore0(int[] scores) {
        int[] newScores = new int[scores.length + 2];
        newScores[0] = 1;
        newScores[scores.length + 1] = 1;
        System.arraycopy(scores, 0, newScores, 1, scores.length);
        return shoot(newScores, 1, scores.length);
    }

    /**
     * 最大分数
     *
     * @param scores 分数数组
     * @return 最大分数
     */
    public static int maxScore1(int[] scores) {
        if (scores == null || scores.length == 0) {
            return 0;
        }
        if (scores.length == 1) {
            return scores[0];
        }
        int[] newScores = new int[scores.length + 2];
        newScores[0] = 1;
        newScores[scores.length + 1] = 1;
        System.arraycopy(scores, 0, newScores, 1, scores.length);
        int[][] dp = new int[scores.length + 2][scores.length + 2];
        for (int i = 1; i <= scores.length; i++) {
            dp[i][i] = newScores[i - 1] * newScores[i] * newScores[i + 1];
        }
        for (int left = scores.length; left >= 1; left--) {
            for (int right = left + 1; right <= scores.length; right++) {
                int finalLeft = newScores[left - 1] * newScores[left] * newScores[right + 1] + dp[left + 1][right];
                int finalRight = newScores[left - 1] * newScores[right] * newScores[right + 1] + dp[left][right - 1];
                dp[left][right] = Math.max(finalLeft, finalRight);
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], newScores[left - 1] * newScores[left] * newScores[right + 1] +
                            dp[left][i - 1] + dp[i + 1][right]);
                }
            }
        }
        return dp[1][scores.length];
    }

    public static void main(String[] args) {
        int[] scores = {3, 2, 5};
        System.out.println(maxScore1(scores));
    }

}
