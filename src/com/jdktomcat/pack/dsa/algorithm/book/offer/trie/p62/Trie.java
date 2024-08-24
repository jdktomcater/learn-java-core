package com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p62;

/**
 * 前缀树
 */
public class Trie {
    public static class TrieNode {
        public TrieNode[] children;
        public boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * 插入
     *
     * @param word 单词
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    /**
     * 查找单词
     *
     * @param word 单词
     * @return true：存在 false：不存在
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }

    /**
     * 前缀开头
     *
     * @param pre 前缀
     * @return true：存在 false：不存在
     */
    public boolean startWith(String pre) {
        TrieNode node = root;
        for (char ch : pre.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }


}
