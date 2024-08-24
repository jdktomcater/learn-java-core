package com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p66;

/**
 * 单词之和
 */
public class MapSum {

    static class TrieNode {
        public TrieNode[] children;

        public int value;

        public TrieNode() {
            children = new TrieNode[26];
        }

    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    /**
     * 插入
     *
     * @param key   键值
     * @param value 值
     */
    public void insert(String key, int value) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.value = value;
    }

    /**
     * 计算和
     *
     * @param prefix 前缀
     * @return 和
     */
    public int sum(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return getSum(node);
    }

    /**
     * 计算节点和
     *
     * @param node 节点
     * @return 和
     */
    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        int value = node.value;
        for (TrieNode child : node.children) {
            value += getSum(child);
        }
        return value;
    }
}
