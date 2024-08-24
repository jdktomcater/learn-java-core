package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd;

import java.util.Arrays;

/**
 * 火柴拼正方形
 */
public class MatchStickMakeSquare {

    /**
     * 火柴拼正方形
     * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。
     * 你要用 所有的火柴棍 拼成一个正方形。
     * 你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
     * <p>
     * 如果你能使这个正方形，则返回 true ，否则返回 false 。
     *
     * @param matchsticks 火柴长度信息
     * @return 能使这个正方形，则返回 true ，否则返回 false
     */
    public static boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int edge = sum / 4;
        if (Arrays.stream(matchsticks).allMatch(value -> value > edge)) {
            return false;
        }
        matchsticks = Arrays.stream(matchsticks).boxed().sorted((a, b) -> b - a).mapToInt(p -> p).toArray();
        int[] edges = new int[4];
        return true;
    }

    /**
     * 深度计算逻辑
     *
     * @param matchsticks 火柴长度信息数组
     * @param edge        边长
     * @param edges       四个边数组
     * @param index       索引
     * @param result      结果
     */
    private static void dfs(int[] matchsticks, int edge, int[] edges, int index, boolean[] result) {
        if (result[0]) {
            return;
        }
        if (index == matchsticks.length) {
            result[0] = true;
            return;
        }

    }

    /**
     * 是否能组成正方形
     *
     * @param matchsticks 数组
     * @return true：能 false：否
     */
    public static boolean makesquareL0(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        matchsticks = Arrays.stream(matchsticks).boxed().sorted((a, b) -> b - a).mapToInt(p -> p).toArray();
        int[] edges = new int[4];
        return dfs(matchsticks, 0, edges, totalLen / 4);
    }

    /**
     * 深度计算逻辑
     *
     * @param matchsticks 数组
     * @param index       索引
     * @param edges       边
     * @param len         长度
     * @return 长度
     */
    public static boolean dfs(int[] matchsticks, int index, int[] edges, int len) {
        // 如果索引到数组全部
        if (index == matchsticks.length) {
            // 成功
            return true;
        }
        // 四个边
        for (int i = 0; i < edges.length; i++) {
            // 加上
            edges[i] += matchsticks[index];
            // 深度遍历
            if (edges[i] <= len && dfs(matchsticks, index + 1, edges, len)) {
                // 返回成功
                return true;
            }
            // 回退
            edges[i] -= matchsticks[index];
        }
        // 返回失败
        return false;
    }
}
