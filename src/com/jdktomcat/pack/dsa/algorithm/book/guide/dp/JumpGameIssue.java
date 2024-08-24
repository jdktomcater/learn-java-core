package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

/**
 * 跳跃游戏相关问题
 */
public class JumpGameIssue {

    /**
     * 跳跃最少步数
     *
     * @param steps 可跳跃信息
     * @return 跳跃最少步数
     */
    public static int jump(int[] steps) {
        if (steps == null || steps.length == 0) {
            return 0;
        }
        int max = 0, cur = 0, step = 0;
        for (int i = 0; i < steps.length - 1; i++) {
            max = Math.max(max, steps[i] + i);
            if (cur == i) {
                cur = max;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] steps = {3, 2, 3, 1, 1, 4};
        System.out.println(jump(steps));
    }

}
