package com.jdktomcat.pack.dsa.algorithm.book.offer.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 树节点
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "" + val;
    }

    /**
     * 数组构造树
     *
     * @param target 目标数组
     * @param index  索引
     * @return 树根节点
     */
    public static TreeNode buildTree(Integer[] target, int index) {
        if (index > target.length) {
            return null;
        }
        if (target[index - 1] == null) {
            return null;
        }
        TreeNode root = new TreeNode(target[index - 1], null, null);
        root.left = buildTree(target, 2 * index);
        root.right = buildTree(target, 2 * index + 1);
        return root;
    }


    /**
     * 中序遍历
     *
     * @return 遍历路径
     */
    public static List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            nodes.add(cur.val);
            cur = cur.right;
        }
        return nodes;
    }

    /**
     * 中序遍历
     *
     * @return 遍历路径
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        inDfs(root, nodes);
        return nodes;
    }

    /**
     * 中序深度遍历
     *
     * @param root  根节点
     * @param nodes 遍历路径
     */
    private static void inDfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            inDfs(root.left, nodes);
            nodes.add(root.val);
            inDfs(root.right, nodes);
        }
    }

    /**
     * 前序遍历
     *
     * @return 遍历路径
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        preDfs(root, nodes);
        return nodes;
    }

    /**
     * 前序深度遍历
     *
     * @param root  根节点
     * @param nodes 遍历路径
     */
    private static void preDfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.val);
            inDfs(root.left, nodes);
            inDfs(root.right, nodes);
        }
    }

    /**
     * 前序遍历
     *
     * @return 遍历路径
     */
    public static List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                nodes.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return nodes;
    }

    /**
     * 后序遍历
     *
     * @return 遍历路径
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        postDfs(root, nodes);
        return nodes;
    }

    /**
     * 后序深度遍历
     *
     * @param root  根节点
     * @param nodes 遍历路径
     */
    private static void postDfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            inDfs(root.left, nodes);
            inDfs(root.right, nodes);
            nodes.add(root.val);
        }
    }

    /**
     * 前序遍历
     *
     * @return 遍历路径
     */
    public static List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != prev) {
                cur = cur.right;
            } else {
                stack.pop();
                nodes.add(cur.val);
                prev = cur;
                cur = null;
            }
        }
        return nodes;
    }

}
