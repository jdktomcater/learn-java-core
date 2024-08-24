package com.jdktomcat.pack.pattern.abstractfactory;

/**
 * 抽象工厂设计模式：在工厂模式之上添加了一个创建不同工厂的抽象接口，该接口称为超级工厂。
 * 通过抽象接口创建出不同的工厂对象，然后根据不同的工厂对象创建不同的对象。
 */
public interface AbstractFactory {

    Phone createPhone(String brand);

    Computer createComputer(String brand);
}
