package com.jdktomcat.pack.dsa.algorithm.company.huawei;

import java.util.Scanner;

public class StringProblem {

    private static void print(String content) {
        if (content.length() > 8) {
            System.out.println(content.substring(0, 8));
            print(content.substring(8));
        } else {
            for (int i = 0; i < 8 - content.length(); i++) {
                content += "0";
            }
            System.out.println(content);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print(scanner.nextLine());
        print(scanner.nextLine());
    }
}
