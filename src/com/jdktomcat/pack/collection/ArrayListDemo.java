package com.jdktomcat.pack.collection;

public class ArrayListDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            System.out.println(i + " " + (i + (i >> 1)));
        }
    }
}
