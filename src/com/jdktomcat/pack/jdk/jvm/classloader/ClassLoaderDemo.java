package com.jdktomcat.pack.jdk.jvm.classloader;

/**
 * 类描述：类加载器示例
 *
 * @author 汤旗
 * @date 2019-05-20 14:45
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLoaderDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLoaderDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLoaderDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
