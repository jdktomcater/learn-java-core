package com.jdktomcat.pack.thread.lock.locks.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述：闭锁/倒计数锁
 *
 * @author 汤旗
 * @date 2019-05-18 10:58
 */
public class CountDownLatchExample {

    // 请求的数量
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            // Lambda 表达式的运用
            threadPool.execute(() -> {
                try {
                    test(threadnum);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    // 表示一个请求已经被完成
                    countDownLatch.countDown();
                }

            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        // 模拟请求的耗时操作
        Thread.sleep(1000);
        System.out.println("threadnum:" + threadnum);
        // 模拟请求的耗时操作
        Thread.sleep(1000);
    }
}
