package com.jdktomcat.pack.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：链表测试
 *
 * @author 汤旗
 * @date 2019-07-08 20:21
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> whiteIpList = new ArrayList<>();
        whiteIpList.add("58.215.108.75");
        whiteIpList.add("111.231.115.79");
        String ip = "111.231.115.79";
        System.out.println(whiteIpList.contains(ip));
    }
}
