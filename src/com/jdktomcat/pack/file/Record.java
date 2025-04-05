package com.jdktomcat.pack.file;

import java.math.BigDecimal;

/**
 * 记录
 */
public class Record {

    private final BigDecimal pre;

    private final BigDecimal post;


    @Override
    public String toString() {
        return "Record{" +
                "pre=" + pre +
                ", post=" + post +
                '}';
    }

    public BigDecimal getPre() {
        return pre;
    }

    public BigDecimal getPost() {
        return post;
    }

    public Record(BigDecimal pre, BigDecimal post) {
        this.pre = pre;
        this.post = post;
    }
}
