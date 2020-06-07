package com.WiltonZhan.leetcode.l126WordLadderII;

import java.util.*;

/*
126. 单词接龙 II
给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []

解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
public class Solution {
    /**
     * 广度优先搜索：将每个单词抽象为一个点，如果两个单词长度相同并且只相差一个字母，就连接它们，最终形成一个无向图。
     * 在图上以beginWord为起点，endWord为终点进行广度优先搜索，寻找出它们之间的最短路径。
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {  // endWord不在wordList中 -> 无解
            return new ArrayList<>();
        }

        if (!wordList.contains(beginWord)) {
            wordList = new ArrayList<>(wordList);
            wordList.add(beginWord);
        }
        Map<String, List<String>> edges = new HashMap<>();  // 构建图
        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            for (int j = 0; j < wordList.size(); j++) {
                String word2 = wordList.get(j);
                if (canTransform(word1, word2)) {
                    if (!edges.containsKey(word1)) {
                        List<String> adjacency = new ArrayList<>();
                        adjacency.add(word2);
                        edges.put(word1, adjacency);
                    } else {
                        edges.get(word1).add(word2);
                    }
                }
            }
        }

        Map<String, Integer> cost = new HashMap<>();    // beginWord到每个点的代价
        for (String word: wordList) {
            cost.put(word, Integer.MAX_VALUE);
        }

        // 将beginWord加入队列，并将其cost设置为0
        Queue<List<String>> queue = new LinkedList<>();
        List<String> tempBegin = new ArrayList<>();
        tempBegin.add(beginWord);
        queue.add(tempBegin);
        cost.put(beginWord, 0);

        List<List<String>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<String> current = queue.poll();
            String lastWord = current.get(current.size() - 1);  // 最近访问的点
            if (lastWord.endsWith(endWord)) {
                result.add(new ArrayList<>(current));
            } else {
                List<String> adjacency = edges.get(lastWord);
                if (adjacency != null) {
                    for (String word : adjacency) {
                        if (cost.get(lastWord) + 1 <= cost.get(word)) {
                            int costToLastWord = cost.get(lastWord);
                            cost.replace(word, costToLastWord + 1);

                            List<String> temp = new ArrayList<>(current);
                            temp.add(word);
                            queue.add(temp);
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean canTransform(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) {
            return false;
        }

        int difference = 0;
        for (int i = 0; i < word1.length() && difference < 2; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                difference++;
            }
        }

        return difference == 1;
    }
}
