package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层次遍历
 */
public class BtTravelLevel {

    /**
     * 二叉树层次遍历
     *
     * @param root 树根节点
     * @return 二叉树层次遍历
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            level.add(node.val);
            if(node.left!=null){
                queue2.offer(node.left);
            }
            if(node.right!=null){
                queue2.offer(node.right);
            }
            if(queue1.isEmpty()){
                queue1 = queue2;
                queue2 = new LinkedList<>();
                result.add(level);
                level = new ArrayList<>();
            }
        }
        return result;
    }
}
