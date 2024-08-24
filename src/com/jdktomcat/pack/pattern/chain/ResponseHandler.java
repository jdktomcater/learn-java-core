package com.jdktomcat.pack.pattern.chain;

public class ResponseHandler extends AbstractHandler implements Handler {

    private String name;

    public ResponseHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println("message response......");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
