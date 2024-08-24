package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数
 */
public class FractionToDecimal {

    /**
     * 分数到小数
     *
     * @param numerator   被除数
     * @param denominator 除数
     * @return 分数到小数
     */
    public static String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        if (numeratorLong % denominatorLong == 0) {
            return numeratorLong / denominatorLong + "";
        }
        StringBuilder result = new StringBuilder(numerator / denominator + ".");
        if ((long) numerator * denominator < 0L && result.charAt(0) != '-') {
            result.insert(0, '-');
        }
        int point = result.length();
        Map<Long, Integer> numIndexMap = new HashMap<>();
        int index = 0;
        denominatorLong = Math.abs((long)denominator);
        long mod = Math.abs(numerator % denominatorLong);
        while (mod != 0 && !numIndexMap.containsKey(mod)) {
            numIndexMap.put(mod, index);
            while (mod < denominatorLong) {
                index++;
                mod *= 10;
                result.append(mod / denominatorLong);
            }
            mod = mod % denominatorLong;
        }
        if (numIndexMap.containsKey(mod)) {
            int startIndex = point + numIndexMap.get(mod);
            result.insert(startIndex, '(');
            result.append(')');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int numerator = -2147483648, denominator = -1;
        System.out.println(fractionToDecimal(numerator, denominator));
    }

}
