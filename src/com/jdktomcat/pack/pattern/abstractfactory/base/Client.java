package com.jdktomcat.pack.pattern.abstractfactory.base;

public class Client {

    public static void main(String[] args) {
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();

        AbstractProductA a1 = creator1.createProductA();
        AbstractProductB b1 = creator1.createProductB();

        AbstractProductA a2 = creator2.createProductA();
        AbstractProductB b2 = creator2.createProductB();

        a1.doSomething();
        b1.doSomething();
        a2.doSomething();
        b2.doSomething();
    }
}
