package com.jdktomcat.pack.dsa.algorithm.company.bytedance;

/**
 * 类描述：数字链表
 *
 * @author 汤旗
 * @date 2019-07-30 10:27
 */
public class NumberList {
    /**
     * 数字链表相加
     *
     * @param root1 链表1
     * @param root2 链表2
     * @return 相加结果
     */
    public static NumberNode numberListAdd(NumberNode root1, NumberNode root2) {
        if (root1 != null && root2 != null) {
            NumberNode root = new NumberNode();
            NumberNode node = root;
            NumberNode node1 = root1;
            NumberNode node2 = root2;
            do {
                Integer maxWeight;
                Integer sumValue;
                if (node1.getWeight() > node2.getWeight()) {
                    maxWeight = node1.getWeight();
                    sumValue = node1.getValue();
                    node1 = node1.getNext();
                } else if (node1.getWeight() < node2.getWeight()) {
                    maxWeight = node2.getWeight();
                    sumValue = node2.getValue();
                    node2 = node2.getNext();
                } else {
                    maxWeight = node1.getWeight();
                    sumValue = node1.getWeight() + node2.getValue();
                    node1 = node1.getNext();
                    node2 = node2.getNext();
                }
                node.setValue(sumValue);
                node.setWeight(maxWeight);
                if (node1 != null && node2 != null) {
                    NumberNode tempNode = node;
                    node = new NumberNode();
                    tempNode.setNext(node);
                }
            } while (node1 != null && node2 != null);
            return root;
        } else if (root1 != null) {
            return root1;
        } else {
            return root2;
        }
    }
}
