package com.jdktomcat.pack.dsa.algorithm.company.cobo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreePathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "" + val;
        }
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
     * 判断是否有路径和为sum
     *
     * @param root 根节点
     * @param sum  和
     * @return true:有 false：没有
     */
    public static boolean existSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        boolean result = false;
        if (root.left != null) {
            result = existSum(root.left, sum - root.val);
        }
        if (!result && root.right != null) {
            result = existSum(root.right, sum - root.val);
        }
        return result;
    }

    /**
     * 判断是否有路径和为sum
     *
     * @param root 根节点
     * @param sum  和
     * @return true:有 false：没有
     */
    public static List<List<TreeNode>> findAllPath(TreeNode root, int sum, List<TreeNode> path) {
        List<List<TreeNode>> pathList = new ArrayList<>();
        if (root == null) {
            return pathList;
        }
        path.add(root);
        if (root.left == null && root.right == null && sum == root.val) {
            pathList.add(path);
            return pathList;
        }
        if (root.left != null) {
            List<TreeNode> leftPath = new ArrayList<>();
            leftPath.addAll(path);
            pathList.addAll(findAllPath(root.left, sum - root.val, leftPath));
        }
        if (root.right != null) {
            List<TreeNode> rightPath = new ArrayList<>();
            rightPath.addAll(path);
            pathList.addAll(findAllPath(root.right, sum - root.val, rightPath));
        }
        return pathList;
    }

    /**
     * 判断根路径最大
     *
     * @param root 根节点
     * @return 最大路径和
     */
    public static int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + Math.max(maxSum(root.left), maxSum(root.right));
    }


    public static void main(String[] args) {
        Integer[] target = new Integer[]{1, null, 4, null, null, 8, 2, null, null, null, null, null, null, 3, 6};
        int sum = 13;
        TreeNode root = buildTree(target, 1);
        List<List<TreeNode>> pathList = findAllPath(root, sum, new ArrayList<>());
        for (List<TreeNode> path : pathList) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
