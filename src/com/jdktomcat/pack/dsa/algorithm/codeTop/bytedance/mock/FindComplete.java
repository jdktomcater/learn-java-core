package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.mock;

public class FindComplete {

    public static int find(int num) {
        boolean[] bit = new boolean[31];
        int index = 0;
        while (num != 0) {
            bit[index++] = (num % 2 == 1);
            num = num / 2;
        }
        int complement = 1, sum = 0;
        for (int i = 0; i < index; i++) {
            if (!bit[i]) {
                sum += complement;
            }
            complement *= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(find(5));
    }
}
