package com.jdktomcat.pack.jdk.thread.lock.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：本地线程变量测试类
 *
 * @author 汤旗
 * @date 2019-05-24 16:36
 */
public class ThreadLocalVariable {
    /**
     * 线程本地变量
     */
    private static ThreadLocal<Map<String, Long>> dataMap = new ThreadLocal<>();

    /**
     * 赋值
     *
     * @param service 服务
     * @param cost    时间
     */
    public static void put(String service, Long cost) {
        Map<String, Long> localMap = dataMap.get();
        if (localMap == null) {
            localMap = new HashMap<>(16);
        }
        localMap.put(service, cost);
        dataMap.set(localMap);
    }
}
