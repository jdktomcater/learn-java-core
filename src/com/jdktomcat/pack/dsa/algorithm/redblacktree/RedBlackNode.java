package com.jdktomcat.pack.dsa.algorithm.redblacktree;

/**
 * 类描述：红黑树节点
 *
 * @author 汤旗
 * @date 2019-05-29 10:27
 */
public class RedBlackNode {

    private int value;

    private RedBlackColorEnum color;

    private RedBlackNode parent;

    private RedBlackNode left;

    private RedBlackNode right;

    public RedBlackNode(int value, RedBlackColorEnum color, RedBlackNode parent,
                        RedBlackNode left, RedBlackNode right) {
        this.value = value;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RedBlackColorEnum getColor() {
        return color;
    }

    public void setColor(RedBlackColorEnum color) {
        this.color = color;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    public RedBlackNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode left) {
        this.left = left;
    }

    public RedBlackNode getRight() {
        return right;
    }

    public void setRight(RedBlackNode right) {
        this.right = right;
    }
}
