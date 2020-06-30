package com.WiltonZhan.leetcode.l409LongestPalindrome;

/*
409. 最长回文串
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Solution {
    /**
     * 对于一个回文串来说，其长度要么为奇数（如：aba），要么为偶数（如：aaaa）。所以我们可以先统计出偶数对（像aa的这种）的数量，然后考虑是否还有剩余字符，有的话就将结果加一
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] count = new int['z' - 'A' + 1];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }

        int len = 0;
        for (int c: count) {
            // 3 / 2 = 1，c / 2 * 2刚好是我们要的这个字符的可用长度
            len += c / 2 * 2;
        }
        if (len != s.length()) {
            len++;
        }
        return len;
    }
}
