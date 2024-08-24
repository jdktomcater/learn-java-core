package com.jdktomcat.pack.jdk.jvm.s02;

/**
 * 类描述：虚拟机栈溢出测试
 *
 * @author 汤旗
 * @date 2019-01-08
 */
public class JavaVMStatckSOF {

    public int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStatckSOF oom = new JavaVMStatckSOF();
        try {
            oom.stackLeak();
        } catch (Throwable a) {
            System.out.println("stack length: " + oom.stackLength);
            throw a;
        }
    }
}
