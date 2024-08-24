package com.jdktomcat.pack.pattern.template;

public class TemplateTest {

    public static void main(String[] args) {
        AbstractTemplate saveMoney = new SaveMoney();
        saveMoney.templateMethod();

        AbstractTemplate takeMoney = new TokeMoney();
        takeMoney.templateMethod();
    }
}
