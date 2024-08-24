package com.jdktomcat.pack.pattern.template;

/**
 * 抽象模板设计模式
 */
public abstract class AbstractTemplate {

    /**
     * 模板方法
     */
    public void templateMethod() {
        checkNum();
        queueUp();
        business();
        serviceEvaluation();
    }

    private void checkNum() {
        System.out.println("check number......");
    }

    private void queueUp() {
        System.out.println("queue up......");
    }

    protected abstract void business();

    private void serviceEvaluation() {
        System.out.println("business finished,service evaluation......");
    }
}
