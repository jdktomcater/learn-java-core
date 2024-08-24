package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和相关问题
 */
public class ThreeNumberSum {

    /**
     * 三和和为0的无重复组合列表
     *
     * @param numbers 数组
     * @return 三和和为0的无重复组合列表
     */
    public static List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers.length > 2) {
            Arrays.sort(numbers);
            int i = 0;
            while (i < numbers.length - 2) {
                int j = i + 1;
                int k = numbers.length - 1;
                while (j < k) {
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        result.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));
                        int temp = numbers[j];
                        while (temp == numbers[j] && j < k) {
                            j++;
                        }
                    } else if (numbers[i] + numbers[j] + numbers[k] > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
                int temp = numbers[i];
                while (temp == numbers[i] && i < numbers.length - 2) {
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(numbers);
        for (List<Integer> path : result) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
