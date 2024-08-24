package com.jdktomcat.pack.dsa.algorithm;

/**
 * 类描述：大数相乘
 *
 * @author 汤旗
 * @date 2019-05-22 13:43
 */
public class StringMulti {

    public static String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] sumArray = new int[length1 + length2];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                sumArray[i + j + 1] += Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
            }
        }
        for (int i = length1 + length2 - 1; i > 0; i--) {
            int over = sumArray[i] / 10;
            if (over != 0) {
                sumArray[i] = sumArray[i] % 10;
                sumArray[i - 1] += over;
            }
        }
        StringBuilder sum = new StringBuilder();
        boolean firstZero = true;
        for (int i = 0; i < length1 + length2; i++) {
            if (sumArray[i] != 0 || !firstZero) {
                sum.append(sumArray[i]);
                firstZero = false;
            }
        }
        if(firstZero){
            sum.append(0);
        }
        return sum.toString();
    }


    public static void main(String[] args) {
        System.out.println(multiply("999999999999999999999999", "9999999999999999"));
    }

}
