package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class RebuildBinaryTree {

    /**
     * 从前序与中序遍历序列构造二叉树
     *
     * @param preOrder 前序访问顺序
     * @param inOrder  中序访问顺序
     * @return 二叉树根节点
     */
    public static TreeNode buildTreeL0(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder.length == 0) {
            return null;
        }
        // 根节点
        TreeNode root = new TreeNode(preOrder[0], null, null);
        // 栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preOrder.length; i++) {
            int preOrderVal = preOrder[i];
            TreeNode node = stack.peek();
            if (node.val != inOrder[inorderIndex]) {
                node.left = new TreeNode(preOrderVal, null, null);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inOrder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preOrderVal, null, null);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 从前序与中序遍历序列构造二叉树
     *
     * @param preOrder 前序访问顺序
     * @param inOrder  中序访问顺序
     * @return 二叉树根节点
     */
    public static TreeNode buildTreeL1(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inOrder[i], i);
        }
        return buildTree(preOrder, 0, n - 1, 0, indexMap);
    }

    /**
     * 构建树
     *
     * @param preOrder      前序序列
     * @param preOrderLeft  前序左索引
     * @param preOrderRight 前序右索引
     * @param inOrderLeft   中序左索引
     * @param indexMap      索引映射
     * @return 树节点
     */
    public static TreeNode buildTree(int[] preOrder, int preOrderLeft, int preOrderRight, int inOrderLeft, Map<Integer, Integer> indexMap) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preOrderRoot = preOrderLeft;
        // 在中序遍历中定位根节点
        int inOrderRoot = indexMap.get(preOrder[preOrderRoot]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preOrder[preOrderLeft], null, null);
        // 得到左子树中的节点数目
        int sizeLeftSubTree = inOrderRoot - inOrderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildTree(preOrder, preOrderLeft + 1, preOrderLeft + sizeLeftSubTree, inOrderLeft, indexMap);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildTree(preOrder, preOrderLeft + sizeLeftSubTree + 1, preOrderRight, inOrderRoot + 1, indexMap);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode root = buildTreeL1(preOrder, inOrder);
        System.out.println(root);
    }


}
