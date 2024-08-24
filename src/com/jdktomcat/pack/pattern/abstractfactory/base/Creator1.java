package com.jdktomcat.pack.pattern.abstractfactory.base;

public class Creator1 extends AbstractCreator{

    /**
     * @return
     */
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    /**
     * @return
     */
    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
