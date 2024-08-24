package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树最大宽度
 * <p>
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，
 * 但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 */
public class BtBiggestWidthLevel {

    /**
     * 二叉树最大宽度
     *
     * @param root 树根节点
     * @return 二叉树最大宽度
     */
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        int maxWidth = 1;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            queue2.offer(node == null ? null : node.left);
            queue2.offer(node == null ? null : node.right);
            if (queue1.isEmpty()) {
                if (!checkAllNull(queue2)) {
                    maxWidth = Math.max(maxWidth, widthLevel(queue2));
                    queue1 = queue2;
                    queue2 = new LinkedList<>();
                }
            }
        }
        return maxWidth;
    }

    /**
     * 层宽度
     *
     * @param root 根节点
     * @return 层最大宽度
     */
    public static int widthOfBinaryTreeL0(TreeNode root) {
        // 如果结点为空，则宽度为0
        if(root == null) {
            return 0;
        }
        // 记录最大宽度
        int width = 0;
        // 队列1，放入TreeNode结点
        Deque<TreeNode> queue1 = new LinkedList<>();
        // 队列2，放入结点的位置索引
        Deque<Integer> queue2 = new LinkedList<>();
        // 放入root结点
        queue1.offerLast(root);
        // 放入root结点的位置索引
        queue2.offerLast(1);
        while(!queue1.isEmpty()) {
            // 当前层的结点数量
            int size = queue1.size();
            // 记录当前层的最大宽度
            int tmpWidth = 0;
            // 用于判断是否为当前层的第一个结点
            boolean flag = false;
            int left = -1, right = -1;
            // 遍历当前层的所有结点
            while(size-- > 0) {
                TreeNode node = queue1.pollFirst();
                int pos = queue2.pollFirst();
                // 遇到第一个结点
                if(!flag) {
                    flag = true;
                    left = pos;
                }
                right = pos;
                // 不停更新当前层的最大宽度
                tmpWidth = Math.max(tmpWidth, right-left+1);
                if(node.left != null) {
                    queue1.offerLast(node.left);
                    queue2.offerLast(pos*2);
                }
                if(node.right != null) {
                    queue1.offerLast(node.right);
                    queue2.offerLast(pos*2+1);
                }
            }
            width = Math.max(width, tmpWidth);
        }
        return width;
    }

    /**
     * 检查队列是否是全部空
     *
     * @param queue 队列
     * @return true：全部空 false：非
     */
    private static boolean checkAllNull(LinkedList<TreeNode> queue) {
        for (TreeNode treeNode : queue) {
            if (treeNode != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 层宽度
     *
     * @param queue 层队列
     * @return 长度
     */
    private static int widthLevel(LinkedList<TreeNode> queue) {
        int left = -1, right = -1;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) != null) {
                if (left == -1) {
                    left = i;
                }
                right = i;
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 3, 2, 5, 3, null, 9};
        System.out.println(widthOfBinaryTreeL0(TreeNode.buildTree(numbers, 1)));
    }
}
