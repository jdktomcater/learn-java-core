package com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p64;

import com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p62.Trie;

/**
 * 神奇的字典
 */
public class MagicDict {

    private final Trie.TrieNode root;

    public MagicDict() {
        root = new Trie.TrieNode();
    }

    /**
     * 构建前缀词典
     *
     * @param dict 词典数组
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            Trie.TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new Trie.TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
    }

    /**
     * 查找目标
     *
     * @param word 目标
     * @return true：找到 false：未找到
     */
    public boolean search(String word) {
        return dfs(root, word, 0, 0);
    }

    /**
     * 查找逻辑
     *
     * @param node 节点
     * @param word 目标
     * @param i    索引
     * @param edit 编辑
     * @return true：存在 false：不存在
     */
    private boolean dfs(Trie.TrieNode node, String word, int i, int edit) {
        if (node == null) {
            return false;
        }
        if (node.isWord && i == word.length() && edit == 1) {
            return true;
        }
        if (i < word.length() && edit <= 1) {
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(i) - 'a' ? edit : edit + 1;
                found = dfs(node.children[j], word, i + 1, next);
            }
            return found;
        }
        return false;
    }
}
