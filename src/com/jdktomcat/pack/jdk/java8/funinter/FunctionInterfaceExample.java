package com.jdktomcat.pack.jdk.java8.funinter;

/**
 * 类描述：函数式接口示例
 *
 * @author 汤旗
 * @date 2019-05-20 15:28
 */
public class FunctionInterfaceExample {

    public static void main(String[] args) {
        // TODO 将数字字符串转换为整数类型
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass());
    }
}
