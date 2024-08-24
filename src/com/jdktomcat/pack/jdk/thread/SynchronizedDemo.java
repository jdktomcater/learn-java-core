package com.jdktomcat.pack.jdk.thread;

/**
 * 类描述：synchronized 关键字JVM底层原理测试类
 *
 * @author 汤旗
 * @date 2019-05-17 16:08
 */
public class SynchronizedDemo {

    public synchronized void method() {
        System.out.println("synchronized 代码块");
    }
}
