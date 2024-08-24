package com.jdktomcat.pack.pattern.bridge;

public abstract class DriverManagerBridge {

    private Driver driver;

    public void execute(){
        driver.executeSQL();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
