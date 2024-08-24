package com.jdktomcat.pack.jdk.java8.funinter;

/**
 * 接口描述：测试接口
 *
 * @author 汤旗
 * @date 2019-05-20 15:35
 */
@FunctionalInterface
public interface Converter<F, T> {
    /**
     * 转化
     * @param f 目标
     * @return 结果
     */
    T convert(F f);
}
