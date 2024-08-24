package com.jdktomcat.pack.pattern.bridge;

public class OracleDriver implements Driver {
    @Override
    public void executeSQL() {
        System.out.println("execute sql by oracle driver");
    }
}
