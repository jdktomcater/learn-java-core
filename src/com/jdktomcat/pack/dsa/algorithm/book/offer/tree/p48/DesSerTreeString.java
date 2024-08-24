package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p48;


import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 序列化和反序列化二叉树
 */
public class DesSerTreeString {

    /**
     * 将树序列化成字符串
     *
     * @param root 树根节点
     * @return 字符串
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return root.val + "," + leftStr + "," + rightStr;
    }

    /**
     * 将字符串反序列化成树
     *
     * @param data 字符串
     * @return 树根节点
     */
    public static TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(",");
        int[] i = new int[0];
        return dfs(nodeStrs, i);
    }

    /**
     * 深度构建树
     *
     * @param strs 节点信息
     * @param i    索引信息
     * @return 树根节点
     */
    private static TreeNode dfs(String[] strs, int[] i) {
        String str = strs[i[0]];
        i[0]++;
        if (str.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str), null, null);
        node.left = dfs(strs, i);
        node.right = dfs(strs, i);
        return node;
    }
}
