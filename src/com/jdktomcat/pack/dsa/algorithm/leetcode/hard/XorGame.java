package com.jdktomcat.pack.dsa.algorithm.leetcode.hard;

/**
 * 类描述：异或游戏
 *
 * @author 11072131
 * @date 2020-04-2020/4/3 17:54
 */
public class XorGame {

    public boolean xorGame(int[] nums) {
        int re = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            re = re ^ nums[i];
        }
        return re == 0;
    }

}
