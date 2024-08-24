package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p118;

import java.util.Arrays;

/**
 * 多余的边
 */
public class RedundantConnection {

    /**
     * 合并集合并
     *
     * @param fathers 集合
     * @param i       索引1
     * @param j       索引2
     * @return true:成功 false：失败
     */
    private static boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }

    /**
     * 查找节点的根节点
     *
     * @param fathers 数组
     * @param i       节点
     * @return 父节点
     */
    private static int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            return findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    /**
     * 查找多余的边
     *
     * @param edges 边信息
     * @return 多余边信息
     */
    public static int[] findRedundantConnection(int[][] edges) {
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, edge[0]);
            maxVertex = Math.max(maxVertex, edge[1]);
        }
        int[] fathers = new int[maxVertex + 1];
        for (int i = 1; i <= maxVertex; i++) {
            fathers[i] = i;
        }
        for (int[] edge : edges) {
            if (!union(fathers, edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,4},{3,4},{2,5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

}
