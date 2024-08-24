package com.jdktomcat.pack.pattern.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        CompanyService recruit = new Proxy(new HumanResource());
        recruit.findWorker("Java");
    }
}
