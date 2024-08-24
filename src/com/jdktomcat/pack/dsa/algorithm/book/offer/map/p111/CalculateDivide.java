package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p111;

import java.util.*;

/**
 * 计算除法
 */
public class CalculateDivide {

    /**
     * 构造图信息
     *
     * @param equations 图相关信息
     * @param values    值信息
     * @return 图信息
     */
    private static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int index = 0; index < equations.size(); index++) {
            String var1 = equations.get(index).get(0);
            String var2 = equations.get(index).get(1);
            graph.putIfAbsent(var1, new HashMap<>());
            graph.get(var1).put(var2, values[index]);
            graph.putIfAbsent(var2, new HashMap<>());
            graph.get(var2).put(var1, 1.0 / values[index]);
        }
        return graph;
    }

    /**
     * 计算除法逻辑
     *
     * @param equations 表达式
     * @param values    值
     * @param queries   查询
     * @return 计算结果
     */
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int index = 0; index < queries.size(); index++) {
            String from = queries.get(index).get(0);
            String to = queries.get(index).get(1);
            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                result[index] = -1;
            } else {
                Set<String> visited = new HashSet<>();
                result[index] = dfs(graph, from, to, visited);
            }
        }
        return result;
    }

    /**
     * 计算结果
     *
     * @param graph   图信息
     * @param from    起始
     * @param to      截止
     * @param visited 已访问节点
     * @return 计算结果
     */
    private static double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {
        if (from.equals(to)) {
            return 1.0;
        }
        visited.add(from);
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double nextValue = dfs(graph, next, to, visited);
                if (nextValue > 0) {
                    return entry.getValue() * nextValue;
                }
            }
        }
        visited.remove(from);
        return -1;
    }

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = new double[]{2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        List<List<String>> equationList = new ArrayList<>();
        for (String[] equation : equations) {
            equationList.add(Arrays.asList(equation));
        }
        List<List<String>> queryList = new ArrayList<>();
        for (String[] query : queries) {
            queryList.add(Arrays.asList(query));
        }
        double[] result = calcEquation(equationList, values, queryList);
        System.out.println("除法计算结果：" + Arrays.toString(result));
    }
}
