package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 */
public class WordBreak {

    /**
     * 单词能否被拆分
     *
     * @param s        目标单词
     * @param wordDict 字典列表
     * @return true：是 false：否
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] result = {false};
        dfs(wordDict, 0, new StringBuilder(s), result);
        return result[0];
    }

    /**
     * 深度遍历计算逻辑
     *
     * @param wordDict 单词列表
     * @param index    索引
     * @param words    拼接字符串
     * @param result   结果
     */
    private static void dfs(List<String> wordDict, int index, StringBuilder words, boolean[] result) {
        if (result[0]) {
            return;
        }
        if (words.length() == 0) {
            result[0] = true;
        } else if (words.length() > 0 && words.toString().endsWith(wordDict.get(index))) {
            for (int i = 0; i < wordDict.size(); i++) {
                int offset = words.length();
                words.delete(offset - wordDict.get(i).length(), offset);
                dfs(wordDict, i, words, result);
                if (result[0]) {
                    return;
                }
                words.append(wordDict.get(i));
            }
        }
    }

    /**
     * 单词能否被拆分
     *
     * @param s        目标单词
     * @param wordDict 字典列表
     * @return true：是 false：否
     */
    public static boolean wordBreakL0(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }




    public static void main(String[] args) {
        String target = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(wordBreak(target, wordDict));
    }
}
