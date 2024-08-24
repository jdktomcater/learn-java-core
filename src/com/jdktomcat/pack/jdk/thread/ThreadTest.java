package com.jdktomcat.pack.jdk.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类描述：线程测试
 *
 * @author 汤旗
 * @date 2019-05-16 21:28
 */
public class ThreadTest {

    /**
     * 共享状态值
     */
    public volatile static AtomicInteger state = new AtomicInteger(1);

    /**
     * 奇数线程
     */
    static class OldThread extends Thread {
        @Override
        public void run() {
            while (state.get() < 10) {
                if(state.get() % 2 != 0){
                    System.out.println(state.get());
                    state.incrementAndGet();
                }
            }
        }
    }

    /**
     * 偶数打印线程
     */
    static class EvenThread extends Thread {
        @Override
        public void run() {
            while (state.get() < 10) {
                if(state.get() % 2 == 0){
                    System.out.println(state.get());
                    state.incrementAndGet();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OldThread oldThread = new OldThread();
        EvenThread evenThread = new EvenThread();
        oldThread.start();
        evenThread.start();
        oldThread.join();
        evenThread.join();
    }
}


