package com.jdktomcat.pack.jdk.hash;

//import org.apache.commons.lang.math.RandomUtils;

/**
 * 测试hash
 *
 * @author: 汤旗
 * @date: 2020-05-08 10:37
 **/
public class HashCodeBean {

    private Integer count;

    private String name;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



//    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(RandomUtils.nextInt(25));
//        }
//    }
}
