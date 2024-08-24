package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.*;

/**
 * 分发糖果
 */
public class CandyIssue {

    /**
     * 分发糖果最少糖果数
     * <p>
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     * 你需要按照以下要求，给这些孩子分发糖果：
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     *
     * @param ratings 小孩评分
     * @return 分发糖果最少糖果数
     */
    public static int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        Map<Integer, Integer> dataMap = new HashMap<>();
        Map<Integer, Integer> inputDegreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> dependencyMap = new HashMap<>();
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                if (ratings[i + 1] >= ratings[i]) {
                    dataMap.put(i, 1);
                } else {
                    Set<Integer> deSet = dependencyMap.getOrDefault(i, new HashSet<>());
                    deSet.add(i + 1);
                    dependencyMap.put(i, deSet);
                    inputDegreeMap.put(i, inputDegreeMap.getOrDefault(i, 0));
                    inputDegreeMap.put(i + 1, inputDegreeMap.getOrDefault(i + 1, 0) + 1);
                }
            } else if (i == ratings.length - 1) {
                if (ratings[i - 1] >= ratings[i]) {
                    dataMap.put(i, 1);
                } else {
                    Set<Integer> deSet = dependencyMap.getOrDefault(i, new HashSet<>());
                    deSet.add(i - 1);
                    dependencyMap.put(i, deSet);
                    inputDegreeMap.put(i, inputDegreeMap.getOrDefault(i, 0));
                    inputDegreeMap.put(i - 1, inputDegreeMap.getOrDefault(i - 1, 0) + 1);
                }
            } else {
                if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                    dataMap.put(i, 1);
                } else {
                    Set<Integer> deSet = dependencyMap.getOrDefault(i, new HashSet<>());
                    deSet.add(i + 1);
                    deSet.add(i - 1);
                    dependencyMap.put(i, deSet);
                    inputDegreeMap.put(i, inputDegreeMap.getOrDefault(i, 0));
                    inputDegreeMap.put(i + 1, inputDegreeMap.getOrDefault(i + 1, 0) + 1);
                    inputDegreeMap.put(i - 1, inputDegreeMap.getOrDefault(i - 1, 0) + 1);
                }
            }
        }
        Set<Integer> zeroSet = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : inputDegreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                zeroSet.add(entry.getKey());
            }
        }
        for (Integer child : zeroSet) {
            Deque<Integer> deque = new LinkedList<>();
            deque.offer(child);
            Deque<Integer> stack = new LinkedList<>();
            while (!deque.isEmpty()) {
                Integer subChild = deque.poll();
                stack.push(subChild);
                inputDegreeMap.remove(subChild);
                Set<Integer> neighbors = dependencyMap.getOrDefault(subChild, new HashSet<>());
                for (Integer neighbor : neighbors) {
                    if (inputDegreeMap.containsKey(neighbor)) {
                        int inDegree = inputDegreeMap.getOrDefault(neighbor, 0) - 1;
                        inputDegreeMap.put(neighbor, inDegree);
                        if (inDegree == 0) {
                            deque.offer(neighbor);
                        }
                    }
                }
            }
            while (!stack.isEmpty()) {
                Integer subChild = stack.pop();
                if (!dataMap.containsKey(subChild)) {
                    if (subChild == 0) {
                        dataMap.put(subChild, dataMap.get(subChild + 1) + 1);
                    } else if (subChild == ratings.length - 1) {
                        dataMap.put(subChild, dataMap.get(subChild - 1) + 1);
                    } else if (ratings[subChild] > ratings[subChild - 1] && ratings[subChild] > ratings[subChild + 1]) {
                        dataMap.put(subChild, Math.min(dataMap.get(subChild + 1) + 1, dataMap.get(subChild - 1) + 1));
                    } else if (ratings[subChild] > ratings[subChild - 1] && ratings[subChild] < ratings[subChild + 1]) {
                        dataMap.put(subChild, Math.min(dataMap.get(subChild + 1) - 1, dataMap.get(subChild - 1) + 1));
                    } else if (ratings[subChild] < ratings[subChild - 1] && ratings[subChild] > ratings[subChild + 1]) {
                        dataMap.put(subChild, Math.min(dataMap.get(subChild + 1) + 1, dataMap.get(subChild - 1) - 1));
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += dataMap.getOrDefault(i, 1);
        }
        return sum;
    }

    /**
     * 两次遍历(左右方向遍历)
     *
     * @param ratings 评分数组
     * @return 最少糖果
     */
    public static int candyL1(int[] ratings) {
        // 左侧遍历
        int[] left = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        // 右侧遍历
        int right = 0, ret = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            // 取最大值
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    public static int candyL0(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 2};
        System.out.println(candyL0(numbers));
    }
}
