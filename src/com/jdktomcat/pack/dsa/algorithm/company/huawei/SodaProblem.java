package com.jdktomcat.pack.dsa.algorithm.company.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类描述：换汽水问题
 *
 * @author 汤旗
 * @date 2019-08-12 15:50
 */
public class SodaProblem {
    /**
     * 一瓶汽水换的瓶子数
     */
    private static final Integer SODA_CHANGE_BOTTLE_NUMBER = 3;

    /**
     * 计算所能换的汽水瓶数
     *
     * @param number 空瓶数
     * @return 汽水瓶数
     */
    public static Integer handle(Integer number) {
        if (number == 0 || number == 1) {
            return 0;
        }
        if (number == 2) {
            return 1;
        }
        int sodaNum = number / SODA_CHANGE_BOTTLE_NUMBER;
        int bottleNum = number % SODA_CHANGE_BOTTLE_NUMBER;
        return sodaNum + handle(sodaNum + bottleNum);
    }


    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine().trim();
        try {
            while (true) {
                Integer number = Integer.parseInt(content);
                if (number <= 100 && number >= 1) {
                    numberList.add(number);
                } else if (number == 0) {
                    break;
                } else {
                    System.out.println("数据输入异常,程序退出!");
                    System.exit(1);
                }
                content = scanner.nextLine().trim();
            }
        } catch (Exception ex) {
            System.out.println("数据输入异常,程序退出!");
            System.exit(1);
        }
        if (numberList.size() != 0) {
            for (Integer number : numberList) {
                System.out.println(handle(number));
            }
        }
    }
}
