package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

/**
 * 跳跃游戏
 */
public class JumpGame {

    /**
     * 跳跃游戏
     *
     * @param numbers 数组
     * @return true：可以跳跃 false：不可跳跃
     */
    public static boolean canJump(int[] numbers) {
        int right = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (i <= right) {
                right = Math.max(right, i + numbers[i]);
                if (right >= numbers.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
