package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

class Trie {
    static class TrieNode {
        char ch;
        boolean isWord;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];
        }

        TrieNode(char ch) {
            this.ch = ch;
            children = new TrieNode[26];
        }

        TrieNode(char ch, boolean isWord) {
            this.ch = ch;
            this.isWord = isWord;
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode(ch);
                node = node.children[ch - 'a'];
            }
        }
        node.isWord = true;
    }

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

    public boolean startWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }
}