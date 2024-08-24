package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 前缀树
 */
public class Trie {

    static class TrieNode {
        /**
         * 是否是单词
         */
        boolean isWord;

        /**
         * 下层节点
         */
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            if (i == word.length() - 1) {
                node.children[ch - 'a'].isWord = true;
            }
            node = node.children[ch - 'a'];
        }
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            if (i != word.length() - 1) {
                node = node.children[ch - 'a'];
            }
        }
        return node.children[word.charAt(word.length() - 1) - 'a'].isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));

    }

}
