package com.jdktomcat.pack.pattern.factory;

public class Factory {

    public static Phone createPhone(String phoneName) {
        if ("huawei".equalsIgnoreCase(phoneName)) {
            return new HuaWei();
        } else if ("iphone".equalsIgnoreCase(phoneName)) {
            return new IPhone();
        }
        return null;
    }
}
