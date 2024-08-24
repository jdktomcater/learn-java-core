package com.jdktomcat.pack.pattern.abstractfactory.base;

public class Creator2 extends AbstractCreator {

    /**
     * @return
     */
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    /**
     * @return
     */
    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
