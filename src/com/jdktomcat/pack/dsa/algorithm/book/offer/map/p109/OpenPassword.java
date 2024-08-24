package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p109;

import java.util.*;

/**
 * 开密码锁
 */
public class OpenPassword {

    /**
     * 计算密码转动相关密码
     *
     * @param pass 原始密码
     * @return 相邻密码列表
     */
    public static List<String> getNeighbors(String pass) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = pass.toCharArray();
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
     * @param pass     目标密码
     * @param deadList 死码
     * @return 转动步骤
     */
    public static int stepPass(String pass, List<String> deadList) {
        String init = "0000";
        if (init.equals(pass)) {
            return 0;
        }
        Set<String> deadSet = new HashSet<>(deadList);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(init);
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.add(init);
        int step = 0;
        while (!queue1.isEmpty()) {
            String cur = queue1.poll();
            if (cur.equals(pass)) {
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
        return 0;
    }

    public static void main(String[] args) {
        String pass = "2292";
        String[] deadPass = new String[]{"0102", "0201"};
        int step = stepPass(pass, Arrays.asList(deadPass));
        System.out.println("开锁步骤：" + step);
    }
}
