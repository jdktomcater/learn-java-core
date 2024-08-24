package com.jdktomcat.pack.dsa.algorithm.company.huawei;

import java.util.Scanner;

public class Main {

    /**
     * 键盘数组
     */
    private static String[] keyArray;

    static {
        keyArray = new String[10];
        keyArray[0] = "0 ";
        keyArray[1] = "1,.";
        keyArray[2] = "2abc";
        keyArray[3] = "3def";
        keyArray[4] = "4ghi";
        keyArray[5] = "5jkl";
        keyArray[6] = "6mno";
        keyArray[7] = "7pqrs";
        keyArray[8] = "8tuv";
        keyArray[9] = "9wxyz";
    }
    private static String handleInput(String input) {
        String result = "";
        // 模式 true 数字 false 英文
        boolean modal = true;
        int delayCount = 0;
        for (int index = 0; index < input.length(); index++) {
            char ch = input.charAt(index);
            if (ch == '#') {
                if (!modal) {
                    if (index > 0) {
                        char before = input.charAt(index - 1);
                        if (Character.isDigit(before)) {
                            int beforeNum = Character.getNumericValue(before);
                            String keyContent = keyArray[beforeNum];
                            int charLength = keyContent.length() - 1;
                            if (charLength != 1) {
                                result += (keyContent.charAt(delayCount % charLength == 0 ? charLength :delayCount % charLength));
                            } else {
                                result += keyContent.charAt(1);
                            }
                        }
                        delayCount = 0;
                    }
                }
                modal = !modal;
            }
            if (ch == '/') {
                if (!modal) {
                    if (index > 0) {
                        char before = input.charAt(index - 1);
                        if (Character.isDigit(before)) {
                            int beforeNum = Character.getNumericValue(before);
                            String keyContent = keyArray[beforeNum];
                            int charLength = keyContent.length() - 1;
                            if (charLength != 1) {
                                result += (keyContent.charAt(delayCount % charLength == 0 ? charLength :delayCount % charLength));
                            } else {
                                result += keyContent.charAt(1);
                            }
                        }
                        delayCount = 0;
                    }
                }
            }
            if (Character.isDigit(ch)) {
                if (modal) {
                    result += input.charAt(index);
                } else {
                    if (index > 0) {
                        char before = input.charAt(index - 1);
                        if (input.charAt(index) != before) {
                            if (Character.isDigit(before)) {
                                int beforeNum = Character.getNumericValue(before);
                                String keyContent = keyArray[beforeNum];
                                int charLength = keyContent.length() - 1;
                                if (charLength != 1) {
                                    result += (keyContent.charAt(delayCount % charLength == 0 ? charLength :delayCount % charLength));
                                } else {
                                    result += keyContent.charAt(1);
                                }
                            }
                            delayCount = 0;
                        }
                    }
                    delayCount++;
                }
            }
        }
        if (!modal) {
            char before = input.charAt(input.length() - 1);
            if (Character.isDigit(before)) {
                int beforeNum = Character.getNumericValue(before);
                String keyContent = keyArray[beforeNum];
                int charLength = keyContent.length() - 1;
                if (charLength != 1) {
                    result += (keyContent.charAt(delayCount % charLength == 0 ? charLength :delayCount % charLength));
                } else {
                    result += keyContent.charAt(1);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(handleInput(scanner.nextLine().trim()));
    }
}
