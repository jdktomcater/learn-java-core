package com.jdktomcat.pack.dsa.algorithm.company.huawei;

import java.util.Scanner;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-05-22 16:13
 */
public class LastWordLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine().trim();
        String[] words = content.split("\\s+");
        System.out.println(words[words.length - 1].length());
    }
}
