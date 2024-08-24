package com.jdktomcat.pack.jdk.jvm.gc;

/**
 * 类描述：垃圾回收测试类
 *
 * @author 汤旗
 * @date 2019-05-20 11:03
 */
public class GcTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900 * 1024];
        allocation2 = new byte[900 * 1024];
    }
}
