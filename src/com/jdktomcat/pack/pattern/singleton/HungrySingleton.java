package com.jdktomcat.pack.pattern.singleton;

/**
 * 饿汉单例模式
 */
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}
