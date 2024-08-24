package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd;

import java.util.*;

/**
 * 密码锁问题
 */
public class PasswordLock {
    /**
     * 计算密码转动相关密码 (图的广度遍历)
     *
     * @param source 密码
     * @return 相邻密码列表
     */
    public static List<String> getNeighbors(String source) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            if (old == '0') {
                chars[i] = '1';
                neighbors.add(new String(chars));
                chars[i] = '9';
                neighbors.add(new String(chars));
            } else if (old == '9') {
                chars[i] = '0';
                neighbors.add(new String(chars));
                chars[i] = '8';
                neighbors.add(new String(chars));
            } else {
                chars[i] = (char) (old + 1);
                neighbors.add(new String(chars));
                chars[i] = (char) (old - 1);
                neighbors.add(new String(chars));
            }
            chars[i] = old;
        }
        return neighbors;
    }


    /**
     * 转动步骤数
     *
     * @param target   目标密码
     * @param deadends 死码
     * @return 转动步骤
     */
    public static int openLock(String[] deadends, String target) {
        String init = "0000";
        if (init.equals(target)) {
            return 0;
        }
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(init);
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        if (!deadSet.contains(init)) {
            queue1.add(init);
        }
        int step = 0;
        while (!queue1.isEmpty()) {
            String cur = queue1.poll();
            if (cur.equals(target)) {
                return step;
            }
            List<String> neighbors = getNeighbors(cur);
            for (String neighbor : neighbors) {
                if (!visitedSet.contains(neighbor) && !deadSet.contains(neighbor)) {
                    queue2.offer(neighbor);
                    visitedSet.add(neighbor);
                }
            }
            if (queue1.isEmpty()) {
                step++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadEnds = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadEnds, target));
    }
}
