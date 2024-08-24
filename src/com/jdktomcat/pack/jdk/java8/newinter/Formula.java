package com.jdktomcat.pack.jdk.java8.newinter;

/**
 * 接口描述：测试接口
 *
 * @author 汤旗
 * @date 2019-05-20 15:11
 */
public interface Formula {

    /**
     * 加法运算
     *
     * @param a 参数1
     * @param b 参数2
     * @return 两数之和
     */
    int add(int a, int b);

    /**
     * 计算平方根
     *
     * @param a 目标值
     * @return 平方根
     */
    default double sqrt(double a) {
        return Math.sqrt(a);
    }

}
