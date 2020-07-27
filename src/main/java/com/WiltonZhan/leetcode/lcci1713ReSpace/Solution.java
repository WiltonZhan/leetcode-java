package com.WiltonZhan.leetcode.lcci1713ReSpace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
面试题 17.13. 恢复空格
哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。

注意：本题相对原题稍作改动，只需返回未识别的字符数



示例：

输入：
dictionary = ["looked","just","like","her","brother"]
sentence = "jesslookedjustliketimherbrother"
输出： 7
解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
提示：

0 <= len(sentence) <= 1000
dictionary中总字符数不超过 150000。
你可以认为dictionary和sentence中只包含小写字母。
 */
public class Solution {
    /**
     *  动态规划。
     *  用dp[i]表示字符串sentence的前i个字符串sentence[0..i-1]中未识别出的字符数量
     *  那么整个匹配过程可以分为两种情况：
     *      1. 有单词匹配上：if (sentence[j..i-1] in dictionary) then dp[i] = dp[j]
     *      2. 没有单词匹配上：else dp[i] = dp[i-1] + 1
     *  因此，我们需要枚举sentence[0..i-1]中的分割点j
     */
    public int respace(String[] dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        int len = sentence.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1; // 先假设一个单词都没匹配上
            for (int j = 0; j < i; j++) {
                if (dictionarySet.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[len];
    }
}
