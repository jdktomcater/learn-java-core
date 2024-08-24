package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p110;

import java.util.*;

/**
 * 所有路径
 * Q：有向无环图
 */
public class AllPath {

    /**
     * 转化下
     *
     * @param nums 数组
     * @return 列表
     */
    private static List<Integer> changeList(int[] nums) {
        Integer[] nodeArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodeArray[i] = nums[i];
        }
        return Arrays.asList(nodeArray);
    }

    /**
     * 遍历
     *
     * @param dataMap 数据
     * @param allPath 结果
     * @param path    路径
     * @param start   开始节点
     * @param end     截止节点
     */
    private static void bfs(Map<Integer, List<Integer>> dataMap, List<List<Integer>> allPath, LinkedList<Integer> path, int start, int end) {
        path.add(start);
        if (start == end) {
            allPath.add(new LinkedList<>(path));
        } else {
            List<Integer> neighbors = dataMap.get(start);
            for (Integer neighbor : neighbors) {
                bfs(dataMap, allPath, path, neighbor, end);
                path.removeLast();
            }
        }
    }

    /**
     * 所有路径
     *
     * @param graph 图信息
     * @param start 起始点
     * @param end   截止点
     * @return 所有路径列表
     */
    public static List<List<Integer>> allPath(int[][] graph, int start, int end) {
        List<List<Integer>> allPath = new LinkedList<>();
        Map<Integer, List<Integer>> dataMap = new HashMap<>();
        for (int index = 0; index < graph.length; index++) {
            List<Integer> neighbors = dataMap.getOrDefault(index, new LinkedList<>());
            neighbors.addAll(changeList(graph[index]));
            dataMap.put(index, neighbors);
        }
        bfs(dataMap, allPath, new LinkedList<>(), start, end);
        return allPath;
    }


    public static void main(String[] args) {
        int start = 0;
        int end = 3;
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> allPath = allPath(graph, start, end);
        allPath.forEach(System.out::println);
    }
}
