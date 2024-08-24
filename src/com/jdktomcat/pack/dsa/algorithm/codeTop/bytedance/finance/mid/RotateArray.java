package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

/**
 * 轮转数组
 */
public class RotateArray {

    /**
     * 轮转数组
     *
     * @param numbers 数组
     * @param k       阈值
     */
    public static void rotate(int[] numbers, int k) {
        int[] newArr = new int[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            newArr[(i + k) % numbers.length] = numbers[i];
        }
        System.arraycopy(newArr, 0, numbers, 0, numbers.length);
    }

    public void rotateL0(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
