package com.jdktomcat.pack.jdk.java8.lambda;

public interface DistributedLock {

    interface Action {
        void act();
    }


    void exclusiveWork(String key, Action action);
}
