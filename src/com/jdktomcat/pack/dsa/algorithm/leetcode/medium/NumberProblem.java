package com.jdktomcat.pack.dsa.algorithm.leetcode.medium;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-08-23 20:26
 */
public class NumberProblem {

    public static int subArraysDivByK(int[] array, int target) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int countNumber = array[i];
            if (countNumber % target == 0) {
                count++;
            }
            for (int j = i + 1; j < array.length; j++) {
                countNumber += array[j];
                if (countNumber % target == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 0, -2, -3, 1};
        int target = 5;
        System.out.println(subArraysDivByK(array, target));
    }


}
