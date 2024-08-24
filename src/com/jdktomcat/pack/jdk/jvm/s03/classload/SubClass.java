package com.jdktomcat.pack.jdk.jvm.s03.classload;

/**
 * 类描述：测试子类
 *
 * @author 汤旗
 * @date 2018-07-31
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass Init!!!");
    }
}
