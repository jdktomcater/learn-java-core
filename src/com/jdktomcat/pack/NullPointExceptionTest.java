package com.jdktomcat.pack;

public class NullPointExceptionTest {


    private static void method(int n){
        System.out.println(n);
    }


    public static void main(String[] args) {
        Integer num = null;
        method(num);
    }
}
