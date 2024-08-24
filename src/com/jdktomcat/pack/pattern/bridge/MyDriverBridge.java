package com.jdktomcat.pack.pattern.bridge;

public class MyDriverBridge extends DriverManagerBridge {

    @Override
    public void execute() {
        getDriver().executeSQL();
    }
}
