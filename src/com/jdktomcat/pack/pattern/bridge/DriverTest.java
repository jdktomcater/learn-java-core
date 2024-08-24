package com.jdktomcat.pack.pattern.bridge;

public class DriverTest {
    public static void main(String[] args) {
        DriverManagerBridge driverManagerBridge = new MyDriverBridge();
        driverManagerBridge.setDriver(new MySQLDriver());
        driverManagerBridge.execute();
        driverManagerBridge.setDriver(new OracleDriver());
        driverManagerBridge.execute();
    }
}

