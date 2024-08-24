package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 完全二叉树校验
 */
public class CompleteBinTree {

    /**
     * 判断二叉树是否是完全二叉树
     *
     * @param root 树根
     * @return true：是 false：否
     */
    public static boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            queue2.offer(node == null ? null : node.left);
            queue2.offer(node == null ? null : node.right);
            if (queue1.isEmpty()) {
                boolean[] status = {false};
                if (checkValid(queue2, status)) {
                    if (status[0]) {
                        queue1 = queue2;
                        queue2 = new LinkedList<>();
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 检验层节点是否完整
     *
     * @param queue 层节点列表
     * @return true：是 false：否
     */
    private static boolean checkValid(LinkedList<TreeNode> queue, boolean[] notAllNull) {
        int firstNullIndex = -1;
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null && firstNullIndex == -1) {
                firstNullIndex = i;
            }
            if (node != null && firstNullIndex != -1 && i > firstNullIndex) {
                return false;
            }
            if (node != null) {
                notAllNull[0] = true;
            }
        }
        return true;
    }

    public static boolean isCompleteTreeL0(TreeNode root) {
        List<TreeIndexNode> nodes = new ArrayList();
        nodes.add(new TreeIndexNode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            TreeIndexNode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new TreeIndexNode(anode.node.left, anode.index * 2));
                nodes.add(new TreeIndexNode(anode.node.right, anode.index * 2 + 1));
            }
        }
        return nodes.get(i - 1).index == nodes.size();
    }

    static class TreeIndexNode {
        TreeNode node;
        int index;

        TreeIndexNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 15};
        TreeNode root = TreeNode.buildTree(numbers, 1);
        System.out.println(isCompleteTree(root));
    }
}
