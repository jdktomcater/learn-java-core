package com.jdktomcat.pack.pattern.book.head_first.chapter03;

public class HouseBlend extends Beverage{

    public HouseBlend(){
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
