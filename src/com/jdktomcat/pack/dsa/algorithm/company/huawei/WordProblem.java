package com.jdktomcat.pack.dsa.algorithm.company.huawei;

import java.util.Scanner;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-08-13 21:25
 */
public class WordProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine().trim().toUpperCase();
        String ch = scanner.nextLine().toUpperCase();
        int index = content.indexOf(ch);
        int count = 0;
        while (index != -1) {
            count++;
            index = content.indexOf(ch, index + 1);
        }
        System.out.println(count);
    }
}
