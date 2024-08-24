package com.jdktomcat.pack.dsa.algorithm.company.cobo;


import java.util.concurrent.Semaphore;

/**
 * 打印线程
 */
public class ThreadPrint {

    public static class PrintThread extends Thread {
        /**
         * 循环次数
         */
        private final int count;

        /**
         * 打印字符
         */
        private final char ch;

        /**
         * 依赖信号量
         */
        private final Semaphore dep;

        /**
         * 本身信号量
         */
        private final Semaphore cur;

        /**
         * 构造器
         *
         * @param name  线程名称
         * @param count 循环次数
         */
        public PrintThread(String name, int count, char ch, Semaphore dep, Semaphore cur) {
            super(name);
            this.count = count;
            this.ch = ch;
            this.dep = dep;
            this.cur = cur;
        }

        @Override
        public void run() {
            for (int c = 0; c < count; c++) {
                try {
                    dep.acquire();
                    System.out.println(currentThread().getName() + "打印：" + ch);
                    cur.release();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int count = 5;
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);
        Semaphore semaphore3 = new Semaphore(0);
        Semaphore semaphore4 = new Semaphore(1);
        new PrintThread("线程A", count, 'C', semaphore4, semaphore1).start();
        new PrintThread("线程B", count, 'O', semaphore1, semaphore2).start();
        new PrintThread("线程C", count, 'B', semaphore2, semaphore3).start();
        new PrintThread("线程D", count, 'O', semaphore3, semaphore4).start();
    }
}
