package com.jdktomcat.pack.jdk.thread;


/**
 * 类描述：线程休眠
 *
 * @author 汤旗
 * @date 2019-05-17 15:44
 */
public class SleepThread extends Thread {

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * {@code (null, null, name)}.
     *
     * @param name the name of the new thread
     */
    public SleepThread(String name) {
        super(name);
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
//     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        try{
            Thread.sleep(3000);
        }catch (Exception ex){

        }
    }
}
