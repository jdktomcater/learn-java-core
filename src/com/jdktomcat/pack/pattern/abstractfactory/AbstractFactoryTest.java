package com.jdktomcat.pack.pattern.abstractfactory;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory phoneFactory = new PhoneFactory();
        Phone applePhone = phoneFactory.createPhone("apple");
        Phone huaweiPhone = phoneFactory.createPhone("huawei");
        System.out.println(applePhone.call());
        System.out.println(huaweiPhone.call());

        AbstractFactory computerFactory = new ComputerFactory();
        Computer appleComputer = computerFactory.createComputer("apple");
        Computer huaweiComputer = computerFactory.createComputer("huawei");
        System.out.println(appleComputer.internet());
        System.out.println(huaweiComputer.internet());

    }
}
