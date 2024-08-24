package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.*;

/**
 * 课程表相关问题
 */
public class CourseIssue {

    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     * <p>
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     *
     * @param numCourses    课程数量
     * @param prerequisites 依赖信息
     * @return true：可以 false：不可以
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> order = getCourseOrder(numCourses, prerequisites);
        return order.size() == numCourses;
    }

    /**
     * 排课程
     *
     * @param numCourses    课程数量
     * @param prerequisites 依赖关系
     * @return 课程列表
     */
    private static List<Integer> getCourseOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inputDegreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> depMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inputDegreeMap.put(i, 0);
            depMap.put(i, new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            inputDegreeMap.put(prerequisite[1], inputDegreeMap.get(prerequisite[1]) + 1);
            Set<Integer> depSet = depMap.get(prerequisite[0]);
            depSet.add(prerequisite[1]);
            depMap.put(prerequisite[0], depSet);
        }
        Queue<Integer> queue = new LinkedList<>();
        inputDegreeMap.forEach((key, value) -> {
            if (value == 0) {
                queue.offer(key);
            }
        });
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);
            Set<Integer> depSet = depMap.get(course);
            for (Integer dep : depSet) {
                int value = inputDegreeMap.get(dep) - 1;
                if (value == 0) {
                    queue.offer(dep);
                } else {
                    inputDegreeMap.put(dep, value);
                }
            }
        }
        return order;
    }

    /**
     * 排课程
     *
     * @param numCourses    课程数量
     * @param prerequisites 依赖关系
     * @return 课程列表
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = getCourseOrder(numCourses, prerequisites);
        if (order.size() != numCourses) {
            return new int[]{};
        }
        int[] orderCourse = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--) {
            orderCourse[i] = order.get(numCourses - 1 - i);
        }
        return orderCourse;
    }
}
