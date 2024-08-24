package com.jdktomcat.pack.dsa.algorithm.company.cobo;

public class ReverseNumber {


    /**
     * 数字反转
     *
     * @param num 原始数字
     * @return 反转后数字
     */
    public static Long reverse(Long num) {
        Long res = 0L;
        while (num != 0) {
            Long temp = num % 10;
            Long last = res;
            res = res * 10 + temp;
            if (last != (res / 10)) {
                return 0L;
            }
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(7085774586302733239L));
    }

}
