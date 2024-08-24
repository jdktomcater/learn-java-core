package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.easy;

import java.util.*;

/**
 * 找到所有数组中消失的数字
 */
public class MissingNumber {

    /**
     * 找到所有数组中消失的数字
     *
     * @param numbers 数组
     * @return 所有数组中消失的数字
     */
    public static List<Integer> findDisappearedNumbers(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(numbers);
        int index = 1, i = 0;
        while (index <= numbers.length) {
            if (i >= numbers.length || index < numbers[i]) {
                result.add(index);
                index++;
            } else if (index == numbers[i]) {
                index++;
            } else {
                i++;
            }
        }
        return result;
    }

    /**
     * 找到所有数组中消失的数字
     *
     * @param numbers 数组
     * @return 所有数组中消失的数字
     */
    public static List<Integer> findDisappearedNumbersL0(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        boolean[] exists = new boolean[numbers.length];
        for (int number : numbers) {
            if (number >= 1 && number <= numbers.length) {
                exists[number - 1] = true;
            }
        }
        for (int i = 0; i < exists.length; i++) {
            boolean exist = exists[i];
            if (!exist) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * 找到所有数组中消失的数字
     *
     * @param numbers 数组
     * @return 所有数组中消失的数字
     */
    public static List<Integer> findDisappearedNumbersL1(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        boolean[] exists = new boolean[numbers.length];
        for (int number : numbers) {
            if (number >= 1 && number <= numbers.length) {
                exists[number - 1] = true;
            }
        }
        for (int i = 0; i < exists.length; i++) {
            boolean exist = exists[i];
            if (!exist) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1};
        List<Integer> result = findDisappearedNumbers(numbers);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
