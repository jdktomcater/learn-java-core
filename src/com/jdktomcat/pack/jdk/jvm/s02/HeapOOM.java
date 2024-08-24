package com.jdktomcat.pack.jdk.jvm.s02;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：内存溢出测试类
 *
 * @author 汤旗
 * @date 2019-01-08
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> arrayList = new ArrayList<>();

        while(true){
            arrayList.add(new OOMObject());
        }
    }
}
