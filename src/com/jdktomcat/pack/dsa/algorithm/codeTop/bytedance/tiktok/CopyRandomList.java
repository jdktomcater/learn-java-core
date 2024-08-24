package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.tiktok;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 */
public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        int index = 0;
        Map<Node, Integer> nodeIndexMap = new HashMap<>();
        Map<Integer, Node[]> newNodeIndexMap = new HashMap<>();
        while (node != null) {
            Node newNode = new Node(node.val);
            nodeIndexMap.put(node, index);
            newNodeIndexMap.put(index, new Node[]{node, newNode});
            node = node.next;
            index++;
        }
        for (int i = 0; i < index; i++) {
            Node[] newNodes = newNodeIndexMap.get(i);
            if (i < index - 1) {
                newNodes[1].next = newNodeIndexMap.get(i + 1)[1];
            }
            if (newNodes[0].random != null) {
                newNodes[1].random = newNodeIndexMap.get(nodeIndexMap.get(newNodes[0].random))[1];
            }

        }
        return newNodeIndexMap.get(0)[1];
    }

    public static void main(String[] args) {
        Integer[][] numbers = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node[] nodes = new Node[numbers.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(numbers[i][0]);
        }
        for (int i = 0; i < nodes.length; i++) {
            if (i < nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
            if (numbers[i][1] != null) {
                nodes[i].random = nodes[numbers[i][1]];
            }
        }
        Node head = copyRandomList(nodes[0]);
        System.out.println(head);
    }

}
