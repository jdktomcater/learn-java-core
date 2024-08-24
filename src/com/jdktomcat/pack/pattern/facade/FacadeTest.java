package com.jdktomcat.pack.pattern.facade;

public class FacadeTest {

    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.startup();
        System.out.println("***********************");
        starter.shutdown();
    }
}
