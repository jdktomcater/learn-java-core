package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 重建二叉树
 */
public class RebuildBinaryTree {

    public TreeNode reBuildTree(int[] preOrder, int pLeft, int pRight, int iLeft, Map<Integer, Integer> indexMap) {
        if (pLeft > pRight) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        // 在中序遍历中定位根节点
        int iRoot = indexMap.get(preOrder[pLeft]);
        // 得到左子树中的节点数目
        int size = iRoot - iLeft;
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preOrder[pLeft], null, null);
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = reBuildTree(preOrder, pLeft + 1, pLeft + size, iLeft, indexMap);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = reBuildTree(preOrder, pLeft + size + 1, pRight, iRoot + 1, indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return reBuildTree(preorder, 0, n - 1, 0, indexMap);
    }

    public static TreeNode buildTreeL0(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }
}
