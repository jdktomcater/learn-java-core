package com.jdktomcat.pack.dsa.algorithm.company.cobo;

import java.util.Arrays;

public class TwoSum {

    /**
     * 查找数组中两个数和为sum
     *
     * @param target 目标数组
     * @param sum    和
     * @return 两个数
     */
    public static int[] twoSum(int[] target, int sum) {
        Arrays.sort(target);
        int start = 0;
        int end = target.length - 1;
        while (start < end) {
            if (target[start] + target[end] == sum) {
                return new int[]{target[start], target[end]};
            } else if (target[start] + target[end] < sum) {
                start++;
            } else {
                end--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] target = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 19;
        System.out.println(Arrays.toString(twoSum(target, sum)));
    }
}
