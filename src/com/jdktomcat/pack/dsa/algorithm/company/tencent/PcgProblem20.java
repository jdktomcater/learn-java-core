package com.jdktomcat.pack.dsa.algorithm.company.tencent;

public class PcgProblem20 {

    /**
     * 转化函数
     *
     * @param num 数字
     * @return 字符串
     */
    public static String convert(int num) {
        boolean time3Flag = (num % 3 == 0);
        boolean time5Flag = (num % 5 == 0);
        if (time3Flag && !time5Flag) {
            return "Fizz";
        } else if (!time3Flag && time5Flag) {
            return "Bizz";
        } else if (time3Flag) {
            return "Fizz Bizz";
        }
        return num + "";
    }


    public static void handle() {
        for (int index = 1; index <= 100; index++) {
            System.out.println(convert(index));
        }
    }

    public static void main(String[] args) {
        handle();
    }


}
