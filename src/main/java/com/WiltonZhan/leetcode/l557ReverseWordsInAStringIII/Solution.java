package com.WiltonZhan.leetcode.l557ReverseWordsInAStringIII;

/*
557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc"
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        StringBuilder result = new StringBuilder();
        int start = 0, end = 0;
        do {
            while (end < len && chars[end] != ' ') {
                end++;
            }
            for (int i = end - 1; i >= start; i--) {
                result.append(chars[i]);
            }
            result.append(' ');
            start = end + 1;
            end = start;
        } while (start < len);

        result.deleteCharAt(len);
        return result.toString();
    }
}
