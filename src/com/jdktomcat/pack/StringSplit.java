package com.jdktomcat.pack;

public class StringSplit {

    private static void change(Integer count) {
        for (int i = 0; i < 10; i++) {
            count++;
        }
    }


    public static void main(String[] args) {
        Integer count = 0;
        change(count);
        System.out.println(count);
    }

}
