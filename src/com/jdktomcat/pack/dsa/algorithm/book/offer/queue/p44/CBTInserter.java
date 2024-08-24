package com.jdktomcat.pack.dsa.algorithm.book.offer.queue.p44;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在完全二叉树中添加节点
 */
public class CBTInserter {

    private Queue<TreeNode> queue;

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.peek();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(v, null, null);
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }

    public TreeNode getRoot() {
        return root;
    }

}
