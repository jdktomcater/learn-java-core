package com.jdktomcat.pack.jdk.thread;


/**
 * 类描述：自定义线程类
 *
 * @author 汤旗
 * @date 2019-05-16 21:30
 */
public class PersonalThread extends Thread {

    private Object object;

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * {@code (null, null, name)}.
     *
     * @param name the name of the new thread
     */
    public PersonalThread(String name, Object object) {
        super(name);
        this.object = object;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行!");
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "获取了对象" + object + "对象锁!!");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "等待后执行!");
    }
}
