package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 环形子数组的最大和
 */
public class MaxSubArraySumCircular {

    /**
     * 环形子数组的最大和
     *
     * @param numbers 数组
     * @return 环形子数组的最大和
     */
    public static int maxSubArraySum(int[] numbers) {
        int pre = 0, max = Integer.MIN_VALUE;
        for (int number : numbers) {
            pre = Math.max(pre + number, number);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static int maxSubArraySumCircular(int[] numbers) {
        // S: sum of A
        int S = 0;
        for (int x : numbers)
            S += x;

        // ans1: answer for one-interval subarray
        int ans1 = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int x : numbers) {
            cur = x + Math.max(cur, 0);
            ans1 = Math.max(ans1, cur);
        }

        // ans2: answer for two-interval subarray, interior in A[1:]
        int ans2 = Integer.MAX_VALUE;
        cur = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.length; ++i) {
            cur = numbers[i] + Math.min(cur, 0);
            ans2 = Math.min(ans2, cur);
        }
        ans2 = S - ans2;

        // ans3: answer for two-interval subarray, interior in A[:-1]
        int ans3 = Integer.MAX_VALUE;
        cur = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 1; ++i) {
            cur = numbers[i] + Math.min(cur, 0);
            ans3 = Math.min(ans3, cur);
        }
        return Math.max(ans1, Math.max(ans2, ans3));
    }

    private static int kadane(int[] numbers, int i, int j, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int ans = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            cur = sign * numbers[k] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    /**
     * 前缀和+单调栈
     *
     * @param numbers 数组
     * @return 最大子数组和
     */
    public int maxSubarraySumCircular(int[] numbers) {
        // Compute P[j] = B[0] + B[1] + ... + B[j-1]
        // for fixed array B = A+A
        int[] P = new int[2 * numbers.length + 1];
        for (int i = 0; i < 2 * numbers.length; ++i) {
            P[i + 1] = P[i] + numbers[i % numbers.length];
        }
        // Want largest P[j] - P[i] with 1 <= j-i <= N
        // For each j, want smallest P[i] with i >= j-N
        int ans = numbers[0];
        // deque: i's, increasing by P[i]
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        for (int j = 1; j <= 2 * numbers.length; ++j) {
            // If the smallest i is too small, remove it.
            if (!deque.isEmpty() && deque.peekFirst() < j - numbers.length) {
                deque.pollFirst();
            }
            // The optimal i is deque[0], for cand. answer P[j] - P[i].
            ans = Math.max(ans, P[j] - P[deque.peekFirst()]);
            // Remove any i1's with P[i2] <= P[i1].
            while (!deque.isEmpty() && P[j] <= P[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] numbers = {-2};
        System.out.println(maxSubArraySumCircular(numbers));
    }

}
