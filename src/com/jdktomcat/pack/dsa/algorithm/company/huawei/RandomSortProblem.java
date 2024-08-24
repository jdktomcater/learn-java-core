package com.jdktomcat.pack.dsa.algorithm.company.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 类描述：随机数排序
 *
 * @author 汤旗
 * @date 2019-08-13 20:17
 */
public class RandomSortProblem {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine().trim();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Integer numberCount = Integer.parseInt(content);
        int n = 0;
        while (n++ < numberCount) {
            content = scanner.nextLine().trim();
            treeSet.add(Integer.parseInt(content));
        }
        for (Integer number : treeSet) {
            System.out.println(number);
        }
    }
}
