package com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p65;

import com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p62.Trie;

/**
 * 最短的单词编码
 */
public class ShortestWordCode {

    /**
     * 构建前缀词典
     *
     * @param dict 词典数组
     */
    public static Trie.TrieNode buildDict(String[] dict) {
        Trie.TrieNode root = new Trie.TrieNode();
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
        return root;
    }

    /**
     * 最短单词编码
     *
     * @param words 单词
     * @return 最短单词编码
     */
    public static int minimumLengthEncoding(String[] words) {
        Trie.TrieNode root = buildDict(words);
        int[] total = {0};
        dfs(root, 1, total);
        return total[0];
    }

    /**
     * 深度优先遍历前缀树
     *
     * @param root   根节点
     * @param length 长度
     * @param total  总数
     */
    private static void dfs(Trie.TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (Trie.TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += length;
        }
    }
}
