package com.jdktomcat.pack.pattern.book.head_first.chapter01;

public class ModelDuck extends Duck{

    public ModelDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck!");
    }
}
