package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串相乘
 */
public class StringMultiply {

    /**
     * 字符串相乘
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return 结果
     */
    public static String multiply(String num1, String num2) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int key = num1.length() - 1 - i + num2.length() - j - 1;
                int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int newValue = resultMap.getOrDefault(key, 0) + value;
                int carry = newValue >= 10 ? newValue / 10 : 0;
                newValue = newValue % 10;
                resultMap.put(key, newValue);
                max = Math.max(max, key);
                while (carry > 0) {
                    key++;
                    newValue = resultMap.getOrDefault(key, 0) + carry;
                    carry = newValue >= 10 ? newValue / 10 : 0;
                    newValue = newValue % 10;
                    resultMap.put(key, newValue);
                    max = Math.max(max, key);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isZero = true;
        for (int i = 0; i <= max; i++) {
            int value = resultMap.getOrDefault(max - i, 0);
            if (value != 0) {
                isZero = false;
            }
            if (!isZero) {
                stringBuilder.append(value);
            }
        }
        if (isZero) {
            stringBuilder.append(0);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "0";
        System.out.println(multiply(num1, num2));
    }

}
