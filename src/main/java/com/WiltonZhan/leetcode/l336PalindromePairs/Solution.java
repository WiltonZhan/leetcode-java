package com.WiltonZhan.leetcode.l336PalindromePairs;

import java.util.*;

/*
336. 回文对
给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。

示例 1:

输入: ["abcd","dcba","lls","s","sssll"]
输出: [[0,1],[1,0],[3,2],[2,4]]
解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
示例 2:

输入: ["bat","tab","cat"]
输出: [[0,1],[1,0]]
解释: 可拼接成的回文串为 ["battab","tabbat"]
 */
public class Solution {
    /**
     * 暴力解法：超时
     */
    public List<List<Integer>> palindromePairs_brute_force(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length < 2) {
            return ans;
        }
        int size = words.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                if (isPalindrome(words[i] + words[j])) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    /**
     * 枚举前后缀
     * 如果字符串A+B是回文，根据A与B长度的不同，可以分为三种情况：
     *  1. len(A) = len(B)：reverse(A) = B
     *  2. len(A) > len(B): A = X + Y, reverse(B) = X && Y is palindrome
     *  3. len(A) < len(B): B = X + Y, reverse(A) = Y && X is palindrome
     * 根据以上分析，我们需要一个能够在一系列字符串中查询某个字符串的翻转是否存在的数据结构，这里用哈希表存储字符串翻转后的信息
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length < 2) {
            return ans;
        }

        int size = words.length;
        // 保存字符串翻转后的值与原字符串的位置关系
        Map<String, Integer> revWordsMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            revWordsMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        // 枚举前后缀
        for (int i = 0; i < size; i++) {
            String word = words[i];
            int len = word.length();
            for (int j = 0; j <= len; j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j, len);
                if (revWordsMap.containsKey(prefix) && isPalindrome(suffix)) {
                    int prefixPos = revWordsMap.get(prefix);
                    if (prefixPos != i) {
                        ans.add(Arrays.asList(i, prefixPos));
                    }

                }

                if (j != 0 && isPalindrome(prefix) && revWordsMap.containsKey(suffix)) {
                    int suffixPos = revWordsMap.get(suffix);
                    if (suffixPos != i) {
                        ans.add(Arrays.asList(suffixPos, i));
                    }
                }
            }
        }

        return ans;
    }



    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}
