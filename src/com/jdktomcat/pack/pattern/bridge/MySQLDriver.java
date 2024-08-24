package com.jdktomcat.pack.pattern.bridge;

public class MySQLDriver implements Driver{
    @Override
    public void executeSQL() {
        System.out.println("execute sql by mysql driver");
    }
}
