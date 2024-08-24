package com.jdktomcat.pack.jdk.jvm.s03;

/**
 * 类描述：垃圾回收测试类
 *
 * @author 汤旗
 * @date 2018-10-08
 */
public class GCTest {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[2 * _1MB];
    }
}
