package com.jdktomcat.pack.pattern.chain;

public class BusinessHandler extends AbstractHandler implements Handler {

    private String name;

    public BusinessHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println("business info handler......");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
