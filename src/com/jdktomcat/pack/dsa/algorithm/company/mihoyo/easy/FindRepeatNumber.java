package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 查找重复数字
 */
public class FindRepeatNumber {

    /**
     * 查找重复数字
     *
     * @param numbers 数组
     * @return 查找重复数字
     */
    public static int findRepeatNumber(int[] numbers) {
        Set<Integer> dataSet = new HashSet<>();
        for (int number : numbers) {
            if(!dataSet.add(number)){
                return number;
            }
        }
        return -1;
    }

    /**
     * 查找重复数字
     *
     * @param numbers 数组
     * @return 查找重复数字
     */
    public static int findRepeatNumberL0(int[] numbers) {
        boolean[] exists = new boolean[numbers.length];
        for (int number : numbers) {
            if(exists[number]){
                return number;
            }
            exists[number] = true;
        }
        return -1;
    }

}
