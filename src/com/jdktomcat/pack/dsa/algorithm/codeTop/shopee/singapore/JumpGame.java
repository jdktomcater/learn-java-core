package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

public class JumpGame {

    /**
     * 反向遍历贪心算法
     *
     * @param nums 数组信息
     * @return 最少步数
     */
    public static int jumpL0(int[] nums) {
        // 位置
        int position = nums.length - 1;
        // 步数
        int steps = 0;
        // 位置边界
        while (position > 0) {
            // 找到最小位置能够跳到目标位置
            for (int i = 0; i < position; i++) {
                // 判断条件
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * 正向遍历贪心算法(每次跳到最远)
     *
     * @param nums 可跳跃信息
     * @return 最少跳跃次数
     */
    public static int jumpL1(int[] nums) {
        // 结尾
        int end = 0;
        // 跳到最远位置
        int maxPosition = 0;
        // 步数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 最大位置计算
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 达到位置
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
