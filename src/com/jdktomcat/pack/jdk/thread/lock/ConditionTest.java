package com.jdktomcat.pack.jdk.thread.lock;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-07-20 11:38
 */
public class ConditionTest {

    public static void main(String[] args) {
        com.jdktomcat.pack.thread.lock.ReentrantLock reentrantLock = new com.jdktomcat.pack.thread.lock.ReentrantLock();
        reentrantLock.newCondition();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    }
}
