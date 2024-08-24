package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.hard;

import java.util.*;

/**
 * 单词搜索 II
 */
public class FindWordBoard {

    /**
     * 单词搜索
     *
     * @param board 矩阵数组信息
     * @param word  单词
     * @return true:存在 false:不存在
     */
    private static boolean exist(char[][] board, String word) {
        boolean[] result = {false};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, word, i, j, new boolean[board.length][board[0].length], 0, result);
                    if (result[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 深度计算逻辑
     *
     * @param board   矩阵数组信息
     * @param word    单词
     * @param i       横坐标
     * @param j       竖坐标
     * @param visited 访问状态记录
     * @param index   索引
     * @param result  结果
     */
    private static void dfs(char[][] board, String word, int i, int j, boolean[][] visited, int index, boolean[] result) {
        if (result[0] || !(i >= 0 && i < board.length && j >= 0 && j < board[0].length) || visited[i][j]) {
            return;
        }
        if (index == word.length() - 1 && board[i][j] == word.charAt(index)) {
            result[0] = true;
        } else if (index < word.length() - 1 && board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            dfs(board, word, i + 1, j, visited, index + 1, result);
            dfs(board, word, i - 1, j, visited, index + 1, result);
            dfs(board, word, i, j + 1, visited, index + 1, result);
            dfs(board, word, i, j - 1, visited, index + 1, result);
            if (!result[0]) {
                visited[i][j] = false;
            }
        }
    }

    /**
     * 单词搜索
     *
     * @param board 字母表
     * @param words 单词列表
     * @return 单词列表
     */
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Map<Integer, Set<TribeNode>> tribeNodeMap = build(board);
        for (String word : words) {
            if (check(tribeNodeMap, word)) {
                result.add(word);
            }
        }
        return result;
    }


    static class TribeNode {
        TribeNode[] children;

        TribeNode() {
            children = new TribeNode[26];
        }
    }

    static class Tribe {
        TribeNode root;

        Tribe() {
            root = new TribeNode();
        }
    }

    private static Map<Integer, Set<TribeNode>> build(char[][] board) {
        Map<Integer, Set<TribeNode>> tribeNodeMap = new HashMap<>();
        Tribe tribe = new Tribe();
        TribeNode root = tribe.root;
        dfs(board, 0, 0, root, tribeNodeMap);
        return tribeNodeMap;
    }

    private static void dfs(char[][] board, int i, int j, TribeNode node, Map<Integer, Set<TribeNode>> tribeNodeMap) {
        if (!(i >= 0 && i < board.length && j >= 0 && j < board[0].length)) {
            return;
        }
        char ch = board[i][j];
        TribeNode nextNode = node.children[ch - 'a'];
        if (nextNode == null) {
            nextNode = new TribeNode();
            Set<TribeNode> set = tribeNodeMap.getOrDefault(ch - 'a', new HashSet<>());
            set.add(nextNode);
            tribeNodeMap.put(ch - 'a', set);
        }
        dfs(board, i + 1, j, nextNode, tribeNodeMap);
        dfs(board, i, j + 1, nextNode, tribeNodeMap);
    }

    /**
     * 单词搜索
     *
     * @param tribeNodeMap 节点信息
     * @param word         单词
     * @return true:存在 false:不存在
     */
    private static boolean check(Map<Integer, Set<TribeNode>> tribeNodeMap, String word) {
        char ch = word.charAt(0);
        Set<TribeNode> set = tribeNodeMap.getOrDefault(ch - 'a', new HashSet<>());
        for (TribeNode node : set) {
            TribeNode cur = node;
            boolean flag = true;
            for (int i = 1; i < word.length() && flag; i++) {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    flag = false;
                } else {
                    cur = cur.children[word.charAt(i) - 'a'];
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> result = findWords(board, words);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
