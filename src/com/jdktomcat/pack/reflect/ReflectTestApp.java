package com.jdktomcat.pack.reflect;

/**
 * 类描述：反射测试应用
 *
 * @author 汤旗
 * @date 2019-11-14 17:59
 */
public class ReflectTestApp {

    public void method(int target) {
        System.out.println(target);
    }

    public static void main(String[] args) {
        ReflectTestApp reflectTestApp = new ReflectTestApp();
        reflectTestApp.method(12);
        ReflectTestApp.class.getMethods();
    }

}
