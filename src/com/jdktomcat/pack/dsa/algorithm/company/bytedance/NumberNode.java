package com.jdktomcat.pack.dsa.algorithm.company.bytedance;

/**
 * 类描述:数字节点描述
 *
 * @author 汤旗
 * @date 2019-07-30 10:24
 */
public class NumberNode {

    private Integer value;

    private Integer weight;

    private NumberNode next;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public NumberNode getNext() {
        return next;
    }

    public void setNext(NumberNode next) {
        this.next = next;
    }
}
