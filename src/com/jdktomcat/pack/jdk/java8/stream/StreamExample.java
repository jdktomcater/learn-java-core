package com.jdktomcat.pack.jdk.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 类描述：流式处理测试类
 *
 * @author 汤旗
 * @date 2019-05-20 15:50
 */
class JavaBean {

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 标识
     */
    private Integer id;

    /**
     * 地址
     */
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class StreamExample {

    /**
     * 并行计算
     */
    public static void concurrentFun() {
        List<Integer> listOfIntegers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listOfIntegers.add(i);
        }
        List<Integer> parallelStorage = new ArrayList<>();
        listOfIntegers.parallelStream().filter(i -> i % 2 == 0).forEach(i -> parallelStorage.add(i));
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
    }

    public static void parallelTest() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        Lock lock = new ReentrantLock();
        long start1 = System.currentTimeMillis();
        IntStream.range(0, 10000).forEach(list1::add);
        System.out.println("串行执行耗时：" + (System.currentTimeMillis() - start1));
        System.out.println("串行执行的大小：" + list1.size());
        long start2 = System.currentTimeMillis();
        IntStream.range(0, 10000).parallel().forEach(list2::add);
        System.out.println("并行执行耗时：" + (System.currentTimeMillis() - start2));
        System.out.println("并行执行的大小：" + list2.size());
        long start3 = System.currentTimeMillis();
        IntStream.range(0, 10000).forEach(i -> {
            lock.lock();
            try {
                list3.add(i);
            } finally {
                lock.unlock();
            }
        });
        System.out.println("加锁并行执行耗时：" + (System.currentTimeMillis() - start3));
        System.out.println("加锁并行执行的大小：" + list3.size());
        long start4 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list4.add(i);
        }
        System.out.println("传统串行执行耗时：" + (System.currentTimeMillis() - start4));
        System.out.println("传统串行执行的大小：" + list4.size());


    }

    public static void main(String[] args) {
        int[] dataArray = new int[]{5, 7, 3, 1};
        System.out.println(Arrays.toString(Arrays.stream(dataArray).map(num -> num + 1).toArray()));
//        concurrentFun();
//        parallelTest();
    }
}
