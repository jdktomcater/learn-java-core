package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.*;

/**
 * 恢复二叉搜索树
 * <p>
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树 。
 */
public class RecoverBinSearchTree {

    /**
     * 恢复二叉搜索树（显式中序遍历）
     * 二叉搜索树中序遍历链表递增
     *
     * @param root 树根节点
     */
    public static void recoverTreeL0(TreeNode root) {
        List<TreeNode> numbers = new ArrayList<>();
        inorder(root, numbers);
        TreeNode[] swapped = findTwoSwapped(numbers);
        swap(swapped[0], swapped[1]);
    }

    /**
     * 中序遍历
     *
     * @param root    树根节点
     * @param numbers 链表
     */
    public static void inorder(TreeNode root, List<TreeNode> numbers) {
        if (root == null) {
            return;
        }
        inorder(root.left, numbers);
        numbers.add(root);
        inorder(root.right, numbers);
    }

    /**
     * 查找目标数字下标
     *
     * @param numbers 链表
     * @return 需要交换下标
     */
    public static TreeNode[] findTwoSwapped(List<TreeNode> numbers) {
        TreeNode node1 = null, node2 = null;
        for (int i = 0; i < numbers.size() - 1; ++i) {
            if (numbers.get(i + 1).val < numbers.get(i).val) {
                node2 = numbers.get(i + 1);
                if (node1 == null) {
                    node1 = numbers.get(i);
                } else {
                    break;
                }
            }
        }
        return new TreeNode[]{node1, node2};
    }

    /**
     * 恢复
     *
     * @param root  树根
     * @param count 统计数字
     * @param x     需交换数字1
     * @param y     需交换数字2
     */
    public static void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }

    /**
     * 恢复二叉搜索树（隐式中序遍历）
     * 二叉搜索树中序遍历链表递增
     *
     * @param root 树根节点
     */
    public static void recoverTreeL1(TreeNode root) {
        // 栈
        Deque<TreeNode> stack = new LinkedList<>();
        // 错误节点
        TreeNode errorNode1 = null, errorNode2 = null, pre = null, cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && cur.val < pre.val) {
                errorNode2 = cur;
                if (errorNode1 == null) {
                    errorNode1 = pre;
                } else {
                    break;
                }
            }
            pre = cur;
            cur = cur.right;
        }
        swap(errorNode1, errorNode2);
    }

    /**
     * 树节点交换
     *
     * @param node1 节点1
     * @param node2 节点2
     */
    public static void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    /**
     * 恢复二叉搜索树（Morris 中序遍历）
     * 二叉搜索树中序遍历链表递增
     *
     * @param root 树根节点
     */
    public static void recoverTreeL2(TreeNode root) {
        TreeNode x = null, y = null, pre = null, predecessor;
        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                    // 说明左子树已经访问完了，我们需要断开链接
                } else {
                    if (pre != null && root.val < pre.val) {
                        y = root;
                        if (x == null) {
                            x = pre;
                        }
                    }
                    pre = root;
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                if (pre != null && root.val < pre.val) {
                    y = root;
                    if (x == null) {
                        x = pre;
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        swap(x, y);
    }
}
