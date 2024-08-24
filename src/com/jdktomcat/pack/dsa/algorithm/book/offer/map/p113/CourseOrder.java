package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p113;

import java.util.*;

/**
 * 课程顺序
 */
public class CourseOrder {

    /**
     * 课程排序
     *
     * @param courseNum     课程数目
     * @param prerequisites 依赖关系
     * @return 课程排序
     */
    public static int[] courseOrder(int courseNum, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i < courseNum; i++) {
            courseMap.put(i, new LinkedList<>());
        }
        int[] inDegree = new int[courseNum];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int depend = prerequisite[1];
            courseMap.get(depend).add(course);
            inDegree[course]++;
        }
        List<Integer> courseOrder = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < courseNum; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.remove();
            courseOrder.add(course);
            for (int next : courseMap.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return courseOrder.size() == courseNum ? courseOrder.stream().mapToInt(i -> i).toArray() : new int[0];
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int courseNum = 4;
        System.out.println(Arrays.toString(courseOrder(courseNum, prerequisites)));
    }
}
