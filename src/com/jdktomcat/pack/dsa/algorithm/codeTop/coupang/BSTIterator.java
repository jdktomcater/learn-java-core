package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树迭代器
 */
public class BSTIterator {

    static Queue<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        Deque<TreeNode> queue1 = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !queue1.isEmpty()) {
            while (cur != null) {
                queue1.push(cur);
                cur = cur.left;
            }
            cur = queue1.poll();
            if (cur != null) {
                queue.offer(cur);
                cur = cur.right;
            }
        }
    }

    public int next() {
        if (hasNext()) {
            return queue.poll().val;
        }
        throw new Error();
    }

    public boolean hasNext() {
        return queue.peek() != null;
    }

    public static void main(String[] args) {
        Integer[] numbers = {7, 3, 15, null, null, 9, 20};
        TreeNode root = TreeNode.buildTree(numbers, 1);
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.hasNext());
    }

}
