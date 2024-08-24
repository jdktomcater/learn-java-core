package com.jdktomcat.pack.dsa.algorithm.company.xiaomi.mid;

import java.util.Arrays;

/**
 * 轮转数组
 */
public class ArrayRotate {
    /**
     * 轮转数组
     *
     * @param numbers 目标数组
     * @param k       目标位数
     */
    public static void rotate(int[] numbers, int k) {
        if (k == 0) {
            return;
        }
        k = k % numbers.length;
        while ((--k) >= 0) {
            int tail = numbers[numbers.length - 1];
            for (int i = numbers.length - 2; i >= 0; i--) {
                numbers[i + 1] = numbers[i];
            }
            numbers[0] = tail;
        }
    }

    public static void rotateL0(int[] numbers, int k) {
        int[] newArr = new int[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            newArr[(i + k) % numbers.length] = numbers[i];
        }
        System.arraycopy(newArr, 0, numbers, 0, numbers.length);
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6};
        int k = 3;
        rotateL0(numbers,k);
        System.out.println(Arrays.toString(numbers));
    }
}
