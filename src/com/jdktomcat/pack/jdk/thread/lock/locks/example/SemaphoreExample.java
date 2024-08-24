package com.jdktomcat.pack.thread.lock.locks.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 类描述：信号量示例测试类
 *
 * @author 汤旗
 * @date 2019-05-18 10:46
 */
public class SemaphoreExample {

    // 请求的数量
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        // 一次只能允许执行的线程数量。
        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            // Lambda 表达式的运用
            threadPool.execute(() -> {
                try {
                    // 获取一个许可，所以可运行线程数量为20/1=20
                    semaphore.acquire();
                    test(threadNum);
                    // 释放一个许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        // 模拟请求的耗时操作
        Thread.sleep(1000);
        System.out.println("threadNum:" + threadNum);
        // 模拟请求的耗时操作
        Thread.sleep(1000);
    }
}
