package com.jdktomcat.pack.jdk.java8.newinter;

/**
 * 类描述：接口方法默认实现
 *
 * @author 汤旗
 * @date 2019-05-20 15:10
 */
public class DefaultInterfaceImpl {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }

            /**
             * 计算平方根
             *
             * @param a 目标值
             * @return 平方根
             */
            @Override
            public double sqrt(double a) {
                return 2 * Math.sqrt(a);
            }
        };
        System.out.println(formula.add(10, 24));
        System.out.println(formula.sqrt(25));
    }

}
