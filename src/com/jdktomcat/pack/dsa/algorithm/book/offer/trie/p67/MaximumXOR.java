package com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p67;

/**
 * 最大异或
 */
public class MaximumXOR {

    static class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }
    }

    /**
     * 构建前缀树
     *
     * @param numbers 数组
     * @return 前缀树节点
     */
    private TrieNode buildTrie(int[] numbers) {
        TrieNode root = new TrieNode();
        for (int num : numbers) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        return root;
    }

    /**
     * 查找最大异或值
     *
     * @param numbers 数组
     * @return 最大异或值
     */
    public int findMaximumXOR(int[] numbers) {
        TrieNode root = buildTrie(numbers);
        int max = 0;
        for (int number : numbers) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (number >> i) & 1;
                if (node.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    node = node.children[1 - bit];
                } else {
                    xor = xor << 1;
                    node = node.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }
}
