package com.jdktomcat.pack.jdk.thread.lock.locks;

/**
 * 类描述：
 *
 *  A synchronizer that may be exclusively owned by a thread.  This
 *  class provides a basis for creating locks and related synchronizers
 *  that may entail a notion of ownership.  The
 *  {@code AbstractOwnableSynchronizer} class itself does not manage or
 *  use this information. However, subclasses and tools may use
 *  appropriately maintained values to help control and monitor access
 *  and provide diagnostics.
 *
 * @author 汤旗
 * @date 2019-04-09 15:32
 */
public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {

    private static final long serialVersionUID = -2366945173832230442L;

    /**
     * Empty constructor for use by subclasses.
     */
    protected AbstractOwnableSynchronizer() { }

    /**
     * The current owner of exclusive mode synchronization.
     */
    private transient Thread exclusiveOwnerThread;

    /**
     * Sets the thread that currently owns exclusive access.
     * A {@code null} argument indicates that no thread owns access.
     * This method does not otherwise impose any synchronization or
     * {@code volatile} field accesses.
     * @param thread the owner thread
     */
    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    /**
     * Returns the thread last set by {@code setExclusiveOwnerThread},
     * or {@code null} if never set.  This method does not otherwise
     * impose any synchronization or {@code volatile} field accesses.
     * @return the owner thread
     */
    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }
}
