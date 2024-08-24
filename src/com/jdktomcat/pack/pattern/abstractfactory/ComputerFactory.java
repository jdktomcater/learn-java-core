package com.jdktomcat.pack.pattern.abstractfactory;

public class ComputerFactory implements AbstractFactory {
    @Override
    public Phone createPhone(String brand) {
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        if ("apple".equalsIgnoreCase(brand)) {
            return new AppleComputer();
        } else if ("huawei".equalsIgnoreCase(brand)) {
            return new HuaweiComputer();
        }
        return null;
    }
}
