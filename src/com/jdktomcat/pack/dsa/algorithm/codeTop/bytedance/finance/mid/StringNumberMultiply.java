package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

/**
 * 字符串相乘
 */
public class StringNumberMultiply {

    /**
     * 字符串相乘
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return 字符串相乘
     */
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] mulArray = new int[chars1.length + chars2.length - 1];
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                mulArray[chars1.length - 1 - i + chars2.length - j - 1] += (chars1[i] - '0') * (chars2[j] - '0');
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int j : mulArray) {
            stringBuilder.append((j + carry) % 10);
            carry = (j + carry) / 10;
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "0";
        System.out.println(multiply(num1, num2));
    }
}
