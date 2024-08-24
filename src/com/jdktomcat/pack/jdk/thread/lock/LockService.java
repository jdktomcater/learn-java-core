package com.jdktomcat.pack.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述：Java锁测试类
 *
 * @author 汤旗
 * @date 2019-04-09 14:50
 */
public class LockService {

    private ReentrantLock lock;

    public LockService(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            Thread.sleep(10000);
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "获得锁定");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final LockService lockService = new LockService(false);

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("我进来了:" + Thread.currentThread().getName());
                lockService.serviceMethod();
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(thread);
        }

        executorService.shutdown();
    }
}
