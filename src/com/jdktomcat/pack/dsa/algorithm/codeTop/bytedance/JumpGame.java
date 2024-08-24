package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 跳跃游戏 II
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 */
public class JumpGame {

    /**
     * 最少跳跃步数（反向查找出发位置）贪心算法
     * <p>
     * 我们的目标是到达数组的最后一个位置，因此我们可以考虑最后一步跳跃前所在的位置，
     * 该位置通过跳跃能够到达最后一个位置。
     * 如果有多个位置通过跳跃都能够到达最后一个位置，那么我们应该如何进行选择呢？
     * 直观上来看，我们可以「贪心」地选择距离最后一个位置最远的那个位置，也就是对应下标最小的那个位置。
     * 因此，我们可以从左到右遍历数组，选择第一个满足要求的位置。
     * 找到最后一步跳跃前所在的位置之后，我们继续贪心地寻找倒数第二步跳跃前所在的位置，
     * 以此类推，直到找到数组的开始位置。
     *
     * @param numbers 数组
     * @return 最少跳跃步数
     */
    public static int jump(int[] numbers) {
        // 位置
        int position = numbers.length - 1;
        // 步数
        int steps = 0;
        // 当位置大于0
        while (position > 0) {
            // 查找最远能跳到目标位置的跳跃点
            for (int i = 0; i < position; i++) {
                if (i + numbers[i] >= position) {
                    // 位置替换
                    position = i;
                    // 步数加一
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * 最少跳跃步数（正向查找出发位置）贪心算法
     *
     * @param numbers 数组
     * @return 最少跳跃步数
     */
    public static int jumpL0(int[] numbers) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + numbers[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 是否跳到最后位置
     *
     * @param numbers 数组
     * @return true：是 false：否
     */
    public static boolean canJump(int[] numbers) {
        boolean[] result = {false};
        dfs(numbers, 0, result);
        return result[0];
    }

    /**
     * 深度遍历计算逻辑
     *
     * @param numbers 数组
     * @param index   索引
     * @param result  结果
     */
    private static void dfs(int[] numbers, int index, boolean[] result) {
        if (result[0]) {
            return;
        }
        if (index >= numbers.length - 1) {
            result[0] = true;
        } else {
            for (int i = numbers[index]; i > 0; i--) {
                dfs(numbers, index + i, result);
            }
        }
    }

    /**
     * 是否跳到最后位置
     *
     * @param numbers 数组
     * @return true：是 false：否
     */
    public static boolean canJumpL1(int[] numbers) {
        int rightMax = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (i <= rightMax) {
                rightMax = Math.max(rightMax, i + numbers[i]);
                if (rightMax >= numbers.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 是否跳到最后位置
     *
     * @param numbers 数组
     * @return true：是 false：否
     */
    public static boolean canJumpL0(int[] numbers) {
        if (numbers.length == 1) {
            return true;
        }
        for (int i = numbers[0]; i > 0; i--) {
            Deque<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int in = queue.poll();
                if (in >= numbers.length - 1) {
                    return true;
                }
                for (int j = numbers[in]; j > 0; j--) {
                    queue.offer(in + j);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {0};
        System.out.println(canJumpL1(numbers));
    }

}
