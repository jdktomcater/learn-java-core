package com.jdktomcat.pack.collection;

/**
 * 类描述：跳表实现简单示例
 *
 * @author 汤旗
 * @date 2019-05-17 21:17
 */
public class ExampleShipList {

    /**
     * 头节点
     */
    private ShipNode head;

    /**
     * 链表长度
     */
    private Integer size;

    public ShipNode getHead() {
        return head;
    }

    public void setHead(ShipNode head) {
        this.head = head;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 添加节点
     *
     * @param value 数值
     */
    public void add(Integer value) {
        if (head == null) {
            head = new ShipNode(new Node(value), null, null);
        } else {

        }
    }

    /**
     * 查找节点
     *
     * @param target 目标值
     * @return 索引
     */
    public Integer getIndex(Integer target) {
        return 0;
    }
}
