package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 */
public class SymmetricBt {

    /**
     * 判断二叉树是否对称 (迭代)
     *
     * @param root 根节点
     * @return true：是 false：否
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        Queue<TreeNode> rightQueue = new LinkedList<>();
        rightQueue.offer(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            } else if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            } else {
                leftQueue.offer(leftNode.left);
                leftQueue.offer(leftNode.right);
                rightQueue.offer(rightNode.right);
                rightQueue.offer(rightNode.left);
            }
        }
        return true;
    }


    /**
     * 判断是否对称（递归）
     *
     * @param root 树根节点
     * @return true：是 false：否
     */
    public static boolean isSymmetricL0(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isLeftRightSymmetric(root.left, root.right);
    }

    /**
     * 判断左右是否对称
     *
     * @param leftNode  左节点
     * @param rightNode 右节点
     * @return true：是 false：否
     */
    private static boolean isLeftRightSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode != null && rightNode != null && leftNode.val == rightNode.val) {
            return isLeftRightSymmetric(leftNode.left, rightNode.right) && isLeftRightSymmetric(leftNode.right, rightNode.left);
        }
        return leftNode == null && rightNode == null;
    }


    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeNode.buildTree(numbers, 1);
        System.out.println(isSymmetric(root));
    }

}
