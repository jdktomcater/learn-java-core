package com.jdktomcat.pack.dsa.algorithm.company.bytedance;

import java.util.*;

/**
 * 类描述：换零钱
 *
 * @author 汤旗
 * @date 2019-08-01 20:59
 */
public class ChangeQuestion {

    /**
     * 换零钱
     *
     * @param units     单元
     * @param total     总值
     * @param line      链表
     * @param targetSet 目标集合
     * @return 换钱结果 -1 不可 0 刚好 1 还可以再换
     */
    private static int change(int[] units, int total, List<Integer> line, Set<String> targetSet) {
        if (line == null) {
            line = new ArrayList<>();
        }
        if (total < 0) {
            line.remove(line.size() - 1);
            return -1;
        } else if (total > 0) {
            for (int unit : units) {
                line.add(unit);
                int result = change(units, total - unit, line, targetSet);
                if (result == 0 || result == -1) {
                    break;
                }
            }
            if (line.size() != 0) {
                line.remove(line.size() - 1);
            }
        } else {
            Object[] numberArray = line.toArray();
            Arrays.sort(numberArray);
            targetSet.add(Arrays.toString(numberArray));
            line.remove(line.size() - 1);
            return 0;
        }
        return 1;
    }

    /**
     * 计算值
     *
     * @param units 单元
     * @param total 总值
     * @return 总个数
     */
    private static int calculate(int[] units, int total) {
        Set<String> targetSet = new HashSet<>();
        change(units, total, null, targetSet);
        Object[] lineArray = targetSet.toArray();
        Arrays.sort(lineArray);
        for (Object line : lineArray) {
            System.out.println(line);
        }
        return targetSet.size();
    }

    /**
     * 主程序入口
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] units = new int[]{1, 2, 5, 10};
        int total = 30;
        System.out.println(calculate(units, total));
    }

}
