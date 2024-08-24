package com.jdktomcat.pack.collection;

/**
 * 类描述：链表节点
 *
 * @author 汤旗
 * @date 2019-05-17 21:25
 */
public class Node {
    /**
     * 节点值
     */
    private Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
