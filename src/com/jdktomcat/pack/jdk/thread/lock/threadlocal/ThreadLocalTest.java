package com.jdktomcat.pack.jdk.thread.lock.threadlocal;

public class ThreadLocalTest {

    private static void testThreadLocal() {
        Thread t = new Thread() {
            ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();
            ThreadLocal<Integer> mIntegerThreadLocal = new ThreadLocal<>();
            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("thread-local-key");
                mIntegerThreadLocal.set(23);
                String localString = mStringThreadLocal.get();
                Integer localInteger = mIntegerThreadLocal.get();
                System.out.println(localString);
                System.out.println(localInteger);
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        testThreadLocal();
    }
}
