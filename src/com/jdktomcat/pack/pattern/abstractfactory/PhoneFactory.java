package com.jdktomcat.pack.pattern.abstractfactory;

/**
 * 工厂设计模式
 */
public class PhoneFactory implements AbstractFactory {
    @Override
    public Phone createPhone(String brand) {
        if ("apple".equalsIgnoreCase(brand)) {
            return new ApplePhone();
        } else if ("huawei".equalsIgnoreCase(brand)) {
            return new HuaweiPhone();
        }
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        return null;
    }
}
