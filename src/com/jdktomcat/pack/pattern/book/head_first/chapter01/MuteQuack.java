package com.jdktomcat.pack.pattern.book.head_first.chapter01;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
