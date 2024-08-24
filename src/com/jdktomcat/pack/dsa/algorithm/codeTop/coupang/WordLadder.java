package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.*;

/**
 * 单词接龙
 * <p>
 * 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列beginWord -> s1-> s2-> ... -> sk：
 * 每一对相邻的单词只差一个字母。
 * 对于1 <= i <= k时，每个si都在wordList中。注意， beginWord不需要在wordList中。
 * sk== endWord
 * 给你两个单词 beginWord和 endWord 和一个字典 wordList ，返回 从beginWord 到endWord 的 最短转换序列 中的 单词数目 。
 * 如果不存在这样的转换序列，返回 0。
 */
public class WordLadder {

    /**
     * 单词接龙最小长度
     *
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  字典列表
     * @return 单词接龙最小长度
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> wordIndexMap = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            wordIndexMap.put(wordList.get(i), i);
        }
        if (!wordIndexMap.containsKey(endWord)) {
            return 0;
        }
        int[] result = {Integer.MAX_VALUE};
        char[] chars = beginWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != chars[i]) {
                    chars[i] = c;
                    String ladder = new String(chars);
                    if (wordIndexMap.containsKey(ladder)) {
                        Set<String> ladderSet = new HashSet<>();
                        ladderSet.add(beginWord);
                        ladderSet.add(ladder);
                        dfs(ladder, endWord, wordIndexMap, ladderSet, 2, result);
                    }
                    chars[i] = ch;
                }
            }
        }
        return result[0] == Integer.MAX_VALUE ? 0 : result[0];
    }


    /**
     * 深度遍历计算逻辑
     *
     * @param beginWord    开始单词
     * @param endWord      结束单词
     * @param wordIndexMap 单词集合
     * @param length       接龙次数
     * @param result       结果
     */
    private static void dfs(String beginWord, String endWord, Map<String, Integer> wordIndexMap, Set<String> ladderSet, int length, int[] result) {
        if (beginWord.equals(endWord)) {
            result[0] = Math.min(result[0], length);
        } else {
            char[] chars = beginWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char ch = chars[i];
                    if (c != chars[i]) {
                        chars[i] = c;
                        String ladder = new String(chars);
                        if (wordIndexMap.containsKey(ladder) && !ladderSet.contains(ladder)) {
                            ladderSet.add(ladder);
                            dfs(ladder, endWord, wordIndexMap, ladderSet, length + 1, result);
                            ladderSet.remove(ladder);
                        }
                    }
                    chars[i] = ch;
                }
            }
        }
    }

    /**
     * 单词接龙最小长度(广度优先遍历)
     *
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  字典列表
     * @return 单词接龙最小长度
     */
    public static int ladderLengthL0(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> wordId = new HashMap<>();
        List<List<Integer>> edge = new ArrayList<>();
        int[] nodeNum = {0};
        // 构建图
        for (String word : wordList) {
            addEdge(word, wordId, edge, nodeNum);
        }
        addEdge(beginWord, wordId, edge, nodeNum);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum[0]];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;
        // 广度优先遍历
        Queue<Integer> que = new LinkedList<>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int nodeId = que.poll();
            if (nodeId == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(nodeId)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[nodeId] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    /**
     * 构建图
     *
     * @param word    单词
     * @param wordId  单词映射
     * @param edge    边
     * @param nodeNum 节点数量
     */
    public static void addEdge(String word, Map<String, Integer> wordId, List<List<Integer>> edge, int[] nodeNum) {
        addWord(word, wordId, edge, nodeNum);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord, wordId, edge, nodeNum);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    /**
     * 添加单词
     *
     * @param word    单词
     * @param wordId  单词映射
     * @param edge    边
     * @param nodeNum 节点数量
     */
    public static void addWord(String word, Map<String, Integer> wordId, List<List<Integer>> edge, int[] nodeNum) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum[0]++);
            edge.add(new ArrayList<>());
        }
    }

    /**
     * 单词接龙最小长度(双向广度优先遍历)
     *
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  字典列表
     * @return 单词接龙最小长度
     */
    public static int ladderLengthL1(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        // 从两端 BFS 遍历要用的队列
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        // 两端已经遍历过的节点
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);

        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < s.length(); ++j) {
                    // 保存第j位的原始字符
                    char c0 = chars[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[j] = c;
                        String newString = new String(chars);
                        // 已经访问过了，跳过
                        if (visited1.contains(newString)) {
                            continue;
                        }
                        // 两端遍历相遇，结束遍历，返回 count
                        if (visited2.contains(newString)) {
                            return count + 1;
                        }
                        // 如果单词在列表中存在，将其添加到队列，并标记为已访问
                        if (allWordSet.contains(newString)) {
                            queue1.offer(newString);
                            visited1.add(newString);
                        }
                    }
                    // 恢复第j位的原始字符
                    chars[j] = c0;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word);
        }
        System.out.println(ladderLengthL1(beginWord, endWord, wordList));
    }

}
