package com.jdktomcat.pack.jdk.jvm.s08;

/**
 * 类描述：静态分派测试
 *
 * @author 汤旗
 * @date 2019-01-09
 */
public class StaticDispatch {
    static abstract class Human{

    }

    static class Man extends Human{

    }

    static class Woman extends Human{

    }

    public void sayHello(Human human){
        System.out.println("hello,guys");
    }

    public void sayHello(Man man){
        System.out.println("hello,boy");
    }

    public void sayHello(Woman woman){
        System.out.println("hello,girl");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }
}
