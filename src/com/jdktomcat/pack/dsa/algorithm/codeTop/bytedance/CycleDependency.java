package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.*;

/**
 * 循环依赖（拓扑排序）
 */
public class CycleDependency {

    /**
     * 检测是否右循环依赖
     *
     * @param dependency 依赖信息
     * @return true：有 false：无
     */
    public static boolean checkCycle(char[][] dependency) {
        Map<Character, Integer> charInputDegreeMap = new HashMap<>();
        Map<Character, Set<Character>> dependencyMap = new HashMap<>();
        for (char[] chars : dependency) {
            Set<Character> characters = dependencyMap.getOrDefault(chars[0], new HashSet<>());
            characters.add(chars[1]);
            dependencyMap.put(chars[0], characters);
            charInputDegreeMap.put(chars[0], charInputDegreeMap.getOrDefault(chars[0], 0));
            charInputDegreeMap.put(chars[1], charInputDegreeMap.getOrDefault(chars[1], 0) + 1);
        }
        Deque<Character> deque = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : charInputDegreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                deque.offer(entry.getKey());
            }
        }
        while (!deque.isEmpty()) {
            char ch = deque.poll();
            charInputDegreeMap.remove(ch);
            Set<Character> characters = dependencyMap.getOrDefault(ch, new HashSet<>());
            for (char dc : characters) {
                if (charInputDegreeMap.containsKey(dc)) {
                    int inDegree = charInputDegreeMap.getOrDefault(dc, 0) - 1;
                    charInputDegreeMap.put(dc, inDegree);
                    if (inDegree == 0) {
                        deque.offer(dc);
                    }
                }
            }
        }
        return charInputDegreeMap.size() != 0;
    }

    /**
     * 合适的路径
     *
     * @param dependency 依赖信息
     * @return 合适路径
     */
    public static List<Character> findPath(char[][] dependency) {
        List<Character> path = new ArrayList<>();
        Map<Character, Integer> charInputDegreeMap = new HashMap<>();
        Map<Character, Set<Character>> dependencyMap = new HashMap<>();
        for (char[] chars : dependency) {
            Set<Character> characters = dependencyMap.getOrDefault(chars[0], new HashSet<>());
            characters.add(chars[1]);
            dependencyMap.put(chars[0], characters);
            charInputDegreeMap.put(chars[0], charInputDegreeMap.getOrDefault(chars[0], 0));
            charInputDegreeMap.put(chars[1], charInputDegreeMap.getOrDefault(chars[1], 0) + 1);
        }
        int size = charInputDegreeMap.size();
        Deque<Character> deque = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : charInputDegreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                deque.offer(entry.getKey());
                path.add(entry.getKey());
            }
        }
        while (!deque.isEmpty()) {
            char ch = deque.poll();
            charInputDegreeMap.remove(ch);
            Set<Character> characters = dependencyMap.getOrDefault(ch, new HashSet<>());
            for (char dc : characters) {
                if (charInputDegreeMap.containsKey(dc)) {
                    int inDegree = charInputDegreeMap.getOrDefault(dc, 0) - 1;
                    charInputDegreeMap.put(dc, inDegree);
                    if (inDegree == 0) {
                        deque.offer(dc);
                        path.add(dc);
                    }
                }
            }
        }
        return path.size() == size ? path : null;
    }

    public static void main(String[] args) {
        char[][] dependency = {{'0', '2'}, {'1', '2'}, {'2', '3'}, {'2', '4'}};
        System.out.println(findPath(dependency));
    }

}
