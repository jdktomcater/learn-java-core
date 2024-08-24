package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和
 */
public class BtPathSum {

    /**
     * 检查是否有存在路径和为sum的
     *
     * @param root 树根
     * @param sum  目标和
     * @return true：存在 false：不存在
     */
    public static boolean checkExistSumPath(TreeNode root, int sum) {
        boolean[] result = {false};
        dfs(root, result, sum);
        return result[0];
    }

    /**
     * 深度遍历计算逻辑
     *
     * @param root 根节点
     * @param sum  和
     * @return true：存在 false：不存在
     */
    private static void dfs(TreeNode root, boolean[] result, int sum) {
        if (result[0]) {
            return;
        }
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            result[0] = true;
            return;
        }
        if (root.left != null) {
            dfs(root.left, result, sum - root.val);
        }
        if (root.right != null) {
            dfs(root.right, result, sum - root.val);
        }
    }

    /**
     * 路径总和 II
     *
     * @param root      树根节点
     * @param targetSum 和值
     * @return 返回路径列表
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfsPath(root, result, targetSum, new LinkedList<>());
        return result;
    }

    /**
     * 深度遍历逻辑
     *
     * @param root   树根
     * @param result 结果
     * @param sum    和值
     * @param path   路径列表
     */
    private static void dfsPath(TreeNode root, List<List<Integer>> result, int sum, LinkedList<Integer> path) {
        if (root != null) {
            path.addLast(root.val);
            sum -= root.val;
            if (root.left == null && root.right == null) {
                if (sum == 0) {
                    result.add(new ArrayList<>(path));
                }
            }
            if (root.left != null) {
                dfsPath(root.left, result, sum, path);
            }
            if (root.right != null) {
                dfsPath(root.right, result, sum, path);
            }
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        int targetSum = 22;
        List<List<Integer>> result = pathSum(TreeNode.buildTree(numbers, 1), targetSum);
        for (List<Integer> path : result) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
