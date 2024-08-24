package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.hard;

/**
 * 正则表达式
 */
public class RegularExpression {

    /**
     *  正则表达匹配
     *
     * @param source 源字符串
     * @param expr 表达式
     * @return true:匹配成功 false:匹配失败
     */
    public static boolean isMatch(String source, String expr) {
        int m = source.length();
        int n = expr.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // 判断是否为*
                if (expr.charAt(j - 1) == '*') {
                    // 前位匹配
                    f[i][j] = f[i][j - 2];
                    // 判断是否匹配
                    if (matches(source, expr, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    // 表达式匹配
                    if (matches(source, expr, i, j)) {
                        // 状态转移方程
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    /**
     * 是否匹配
     *
     * @param source 源字符串
     * @param expr 表达式
     * @param i 源字符串索引
     * @param j 表达式索引
     * @return true：匹配 false：不匹配
     */
    public static boolean matches(String source, String expr, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (expr.charAt(j - 1) == '.') {
            return true;
        }
        return source.charAt(i - 1) == expr.charAt(j - 1);
    }

    static class TrieNode{

        boolean isEnd;
        TrieNode[] children;

        TrieNode (){
            children = new TrieNode[28];
        }
    }

    static class Trie{
        TrieNode root;
        Trie(String expr){
            root = new TrieNode();
            TrieNode node = root;
            for (int i=0;i<expr.length();i++){
                char ch = expr.charAt(i);
                TrieNode nextNode;
                if(ch=='*'){
                    if(node.children[26]==null){
                        node.children[26] = new TrieNode();
                    }
                    nextNode = node.children[26];
                }else if(ch == '.'){
                    if(node.children[27]==null){
                        node.children[27] = new TrieNode();
                    }
                    nextNode = node.children[27];
                }else {
                    if(node.children[ch - 'a']==null){
                        node.children[ch - 'a'] = new TrieNode();
                    }
                    nextNode = node.children[ch - 'a'];
                }
                node = nextNode;
            }
            node.isEnd = true;
        }
    }

    /**
     *  正则表达匹配
     *
     * @param source 源字符串
     * @param expr 表达式
     * @return true:匹配成功 false:匹配失败
     */
    public static boolean isMatchL0(String source, String expr) {
        Trie trie = new Trie(expr);
        return false;
    }
}
