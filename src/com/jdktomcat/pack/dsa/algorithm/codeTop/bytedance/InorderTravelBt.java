package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树中序遍历
 */
public class InorderTravelBt {

    /**
     * 中序遍历二叉树
     *
     * @param root 树根节点
     * @return 中序遍历列表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    /**
     * 深度处理逻辑
     *
     * @param root   根节点
     * @param result 结果
     */
    private static void dfs(TreeNode root, List<Integer> result) {
        if (root != null) {
            dfs(root.left, result);
            result.add(root.val);
            dfs(root.right, result);
        }
    }

}
