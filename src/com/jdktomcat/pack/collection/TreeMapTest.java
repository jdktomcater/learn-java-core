package com.jdktomcat.pack.collection;

import java.util.TreeMap;

/**
 * 类描述：treemap测试类
 *
 * @author 汤旗
 * @date 2019-05-24 10:01
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap.put("key" + i, 10 - i);
        }
        System.out.println(treeMap);
    }
}
