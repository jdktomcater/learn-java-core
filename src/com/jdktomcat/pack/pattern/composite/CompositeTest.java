package com.jdktomcat.pack.pattern.composite;

public class CompositeTest {

    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        nodeA.add(nodeB);
        System.out.println(nodeA);
    }
}
