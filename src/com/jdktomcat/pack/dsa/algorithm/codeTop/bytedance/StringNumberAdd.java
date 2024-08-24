package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 字符串相加
 */
public class StringNumberAdd {

    /**
     * 字符串数字相加
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return 相加结果
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder sumSb = new StringBuilder();
        int carry = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        while (index1 >= 0 && index2 >= 0) {
            int n1 = num1.charAt(index1--) - '0';
            int n2 = num2.charAt(index2--) - '0';
            int sum = n1 + n2 + carry;
            sumSb.append(sum % 10);
            carry = sum >= 10 ? 1 : 0;
        }
        if (index1 >= 0) {
            while (index1 >= 0) {
                int n1 = num1.charAt(index1--) - '0' + carry;
                sumSb.append(n1 % 10);
                carry = n1 >= 10 ? 1 : 0;
            }
        }
        if (index2 >= 0) {
            while (index2 >= 0) {
                int n2 = num2.charAt(index2--) - '0' + carry;
                sumSb.append(n2 % 10);
                carry = n2 >= 10 ? 1 : 0;
            }
        }
        if (carry > 0) {
            sumSb.append(carry);
        }
        return sumSb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        System.out.println(addStrings(num1, num2));
    }

}
