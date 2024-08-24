package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.*;

/**
 * 课程表 II
 * <p>
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 */
public class ScheduleOrder {

    /**
     * 课程表排序
     *
     * @param numCourses    课程数目
     * @param prerequisites 依赖关系
     * @return 可行课程表序列
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inputDegreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> depMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inputDegreeMap.put(i, 0);
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int dependency = prerequisite[1];
            inputDegreeMap.put(dependency, inputDegreeMap.get(dependency) + 1);
            Set<Integer> depSet = depMap.getOrDefault(course, new HashSet<>());
            depSet.add(dependency);
            depMap.put(course, depSet);
        }
        Deque<Integer> courseQueue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inputDegreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                courseQueue.offer(entry.getKey());
            }
        }
        List<Integer> courseOrder = new ArrayList<>();
        while (!courseQueue.isEmpty()) {
            int course = courseQueue.poll();
            courseOrder.add(course);
            Set<Integer> depSet = depMap.getOrDefault(course, new HashSet<>());
            for (Integer dep : depSet) {
                int inputDegree = inputDegreeMap.get(dep) - 1;
                if (inputDegree <= 0) {
                    courseQueue.offer(dep);
                } else {
                    inputDegreeMap.put(dep, inputDegree);
                }
            }
        }
        if (courseOrder.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[courseOrder.size()];
        for (int i = 0; i < courseOrder.size(); i++) {
            result[i] = courseOrder.get(courseOrder.size() - 1 - i);
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(num, prerequisites)));
    }

}
