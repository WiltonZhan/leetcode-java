package com.WiltonZhan.leetcode.l14LongestCommonPrefix;

/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        String longestCommonPrefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            longestCommonPrefix = commonPrefix(longestCommonPrefix, strs[i]);
        }
        return longestCommonPrefix;
    }

    private String commonPrefix(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "";
        }
        int len = Math.min(s1.length(), s2.length());
        int i = 0;
        for(; i < len; i++){
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
        }
        return s1.substring(0, i);
    }
}
