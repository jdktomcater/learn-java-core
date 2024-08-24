package com.jdktomcat.pack.pattern.singleton;

/**
 * 懒汉单例模式
 */
public class DclSingleton {
    private DclSingleton() {
    }

    private volatile static DclSingleton instance;

    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

}
