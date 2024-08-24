package com.jdktomcat.pack.dsa.algorithm.lru;

/**
 * 类描述：双向链表节点
 *
 * @author 汤旗
 * @date 2019-07-30 21:26
 */
public class DoubleLinkedNode {

    private String key;

    private int value;

    private DoubleLinkedNode pre;

    private DoubleLinkedNode next;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleLinkedNode getPre() {
        return pre;
    }

    public void setPre(DoubleLinkedNode pre) {
        this.pre = pre;
    }

    public DoubleLinkedNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode next) {
        this.next = next;
    }
}
