package com.jdktomcat.pack.pattern.decorator;

public class Source implements Sourceable {

    @Override
    public void createComputer() {
        System.out.println("create computer by source......");
    }
}
