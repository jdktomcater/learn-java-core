package com.jdktomcat.pack.pattern.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * 代理设计模式
 */
public class Proxy implements CompanyService {

    private final HumanResource hr;

    public Proxy(HumanResource hr) {
        super();
        this.hr = hr;
    }

    @Override
    public void findWorker(String title) {
        hr.findWorker(title);
        String worker = getWorker(title);
        System.out.println("find a worker by proxy,work name is " + worker);
    }

    private String getWorker(String title) {
        Map<String, String> workerMap = new HashMap<>();
        workerMap.put("Java", "张三");
        workerMap.put("Python", "李四");
        workerMap.put("Php", "王五");
        workerMap.put("Node", "陈六");
        return workerMap.get(title);
    }
}
