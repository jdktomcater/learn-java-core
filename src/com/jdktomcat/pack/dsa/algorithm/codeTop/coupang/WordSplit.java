package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 */
public class WordSplit {

    /**
     * 单词是否可以拆分（动态规划）
     * 边界条件：dp[0] = true
     * 状态转移方程：dp[i] = dp[j] && wordDict.contains(s[j,i])
     *
     * @param s        目标字符串
     * @param wordDict 单词字典
     * @return true：可以 false：不可以
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
