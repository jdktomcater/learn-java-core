package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.*;

/**
 * 以图判树
 */
public class MapValidTree {

    /**
     * 给定编号从 0 到 n - 1 的 n 个结点。给定一个整数 n 和一个 edges 列表，
     * 其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间存在一条无向边。
     * 如果这些边能够形成一个合法有效的树结构，则返回 true ，否则返回 false 。
     *
     * @param n     节点数量
     * @param edges 图信息
     * @return true：树 false：非树
     */
    public static boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> neighborMap = new HashMap<>();
        int[] father = new int[n];
        father[n - 1] = n;
        for (int[] edge : edges) {
            Set<Integer> neighborSet0 = neighborMap.getOrDefault(edge[0], new HashSet<>());
            neighborSet0.add(edge[1]);
            neighborMap.put(edge[0], neighborSet0);
            Set<Integer> neighborSet1 = neighborMap.getOrDefault(edge[1], new HashSet<>());
            neighborSet1.add(edge[0]);
            neighborMap.put(edge[1], neighborSet1);
        }
        // 判断是否全部节点连接
        if (neighborMap.size() != n) {
            return false;
        }
        Queue<Integer> queueFa = new LinkedList<>();
        queueFa.offer(n - 1);
        while (!queueFa.isEmpty()) {
            int node = queueFa.poll();
            father[node] = n;
            Set<Integer> neighborSet = neighborMap.get(node);
            for (int neighbor : neighborSet) {
                if (father[neighbor] != n) {
                    queueFa.offer(neighbor);
                }
            }
        }
        for (int f : father) {
            if (f != n) {
                return false;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> neighborSet = neighborMap.get(i);
            if (neighborSet.size() == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            Set<Integer> neighborSet = neighborMap.get(node);
            for (int neighbor : neighborSet) {
                Set<Integer> subNeighborSet = neighborMap.get(neighbor);
                subNeighborSet.remove(node);
                neighborMap.put(neighbor, subNeighborSet);
                if (subNeighborSet.size() == 1) {
                    queue.offer(neighbor);
                }
            }
            neighborMap.remove(node);
        }
        return neighborMap.size() == 0;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(n, edges));
    }
}
