package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p106;

import java.util.Arrays;

/**
 * 二分图问题
 * Q:如果能将一个图中的节点分成A\B两部分，使任意一条边的
 * 节点属于A，而另外一个节点属于B，那么该图就是二分图。
 */
public class BinaryMap {

    /**
     * 设置颜色
     *
     * @param graph     图信息
     * @param nodeColor 节点颜色信息
     * @param color     颜色
     * @param index     节点索引
     * @return true：设置成功 false：设置失败
     */
    private static boolean setColor(int[][] graph, int[] nodeColor, int color, int index) {
        if (nodeColor[index] >= 0) {
            return nodeColor[index] == color;
        }
        nodeColor[index] = color;
        int[] nodes = graph[index];
        for (int node : nodes) {
            // 深度遍历
            if (!setColor(graph, nodeColor, 1 - color, node)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断是否是二分图
     *
     * @param graph 图信息
     * @return true:是 false：否
     */
    public static boolean isBiMap(int[][] graph) {
        int[] nodeColor = new int[graph.length];
        Arrays.fill(nodeColor, -1);
        for (int index = 0; index < graph.length; index++) {
            if (nodeColor[index] == -1 && !setColor(graph, nodeColor, 0, index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        boolean isBiMap = isBiMap(graph);
        System.out.println("该图是否是二分图：" + isBiMap);
    }

}
