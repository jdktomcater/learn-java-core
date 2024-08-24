package com.jdktomcat.pack.jdk.serializable;

import java.io.Serializable;

/**
 * 类描述：序列化类测试
 *
 * @author 汤旗
 * @date 2019-04-25 16:05
 */
public class SerializableTest implements Serializable {
    private static final long serialVersionUID = -1110364083284251701L;

    private Integer age;



    public static void main(String[] args) {
        final Object serializableTest = new SerializableTest();
        System.out.println(serializableTest instanceof Serializable);
    }
}
