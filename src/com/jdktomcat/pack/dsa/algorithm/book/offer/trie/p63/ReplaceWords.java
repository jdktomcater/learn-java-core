package com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p63;

import com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p62.Trie;

import java.util.Arrays;
import java.util.List;

/**
 * 单词替换
 */
public class ReplaceWords {

    /**
     * 根据词根字典构建前缀树
     *
     * @param dict 词根字典
     * @return 前缀树根节点
     */
    private static Trie.TrieNode buildTree(List<String> dict) {
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
     * 查找前缀
     *
     * @param root 前缀树根节点
     * @param word 单词
     * @return 前缀
     */
    private static String findPrefix(Trie.TrieNode root, String word) {
        Trie.TrieNode node = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (node.isWord || node.children[ch - 'a'] == null) {
                break;
            }
            stringBuilder.append(ch);
            node = node.children[ch - 'a'];
        }
        return node.isWord ? stringBuilder.toString() : "";
    }

    /**
     * 单词替换
     *
     * @param dict     词根词典
     * @param sentence 句子
     * @return 替换后字符串
     */
    public static String replaceWords(List<String> dict, String sentence) {
        Trie.TrieNode root = buildTree(dict);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if (!prefix.isEmpty()) {
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String[] dict = new String[]{"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by battery";
        System.out.println(replaceWords(Arrays.asList(dict), sentence));
    }

}
