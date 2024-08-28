package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p50;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 向下的路径节点值之和
 */
public class CountPathSum {

    /**
     * 向下的路径节点值之和的路径数
     *
     * @param root 树根节点
     * @param sum  和
     * @return 路径个数
     */
    public static int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> pathMap = new HashMap<>();
        pathMap.put(0, 1);
        return dfs(root, sum, pathMap, 0);
    }

    /**
     * 深度遍历计算
     *
     * @param root    根节点
     * @param sum     和
     * @param pathMap 路径和映射
     * @param path    路径
     * @return 路径数
     */
    private static int dfs(TreeNode root, int sum, Map<Integer, Integer> pathMap, int path) {
        if (root == null) {
            return 0;
        }
        path += root.val;
        int count = pathMap.getOrDefault(path - sum, 0);
        pathMap.put(path, pathMap.getOrDefault(path, 0) + 1);
        count += dfs(root.left, sum, pathMap, path);
        count += dfs(root.right, sum, pathMap, path);
        pathMap.put(path, pathMap.get(path) - 1);
        return count;
    }
}
