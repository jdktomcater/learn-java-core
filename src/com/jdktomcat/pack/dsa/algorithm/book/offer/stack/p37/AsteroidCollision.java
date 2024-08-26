package com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p37;

import java.util.Stack;

/**
 * 小行星碰撞
 */
public class AsteroidCollision {

    /**
     * 小行星碰撞
     *
     * @param asteroids 信息
     * @return 结果
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                stack.pop();
            }
            if (!stack.isEmpty() && asteroid < 0 && stack.peek() == -asteroid) {
                stack.pop();
            } else if (asteroid > 0 || stack.empty() || stack.peek() < 0) {
                stack.push(asteroid);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
