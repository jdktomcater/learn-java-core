package com.jdktomcat.pack.jdk.thread;

/**
 * 类描述：单例实现
 *
 * @author 汤旗
 * @date 2019-05-17 16:03
 */
public class Singleton {

    private static volatile Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}


