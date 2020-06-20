package com.WiltonZhan.leetcode.l10RegularExpressionMatching;

import java.util.regex.Pattern;

/*
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
 */
public class Solution {
    /**
     *  动态规划
     *  用m[i][j]表示s的前i个字符能否被p的前j个字符匹配上。
     *  1. if s[i] == p[j], then m[i][j] = m[i-1][j-1]
     *  2. if p[j] == '.', then m[i][j] = m[i-1][j-1]
     *  3. if p[j] == '*':
     *      3.1. if s[i] != p[j-1], then m[i][j] = m[i][j-2]    // '*'的前一个字符和s[i]匹配不上，字符+'*'的组合只能被认为匹配0次字符s[i]
     *      3.2. if s[i] == p[j-1] or p[j-1] == '.', then
     *          m[i][j] = m[i-1][j] // a* counts as multiple a
     *          or m[i][j] = m[i][j-1]  // a* counts as single a
     *          or m[i][j] = m[i][j-2]  // a* counts as empty
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int sLen = s.length(), pLen = p.length();
        boolean[][] m = new boolean[sLen + 1][pLen + 1];
        m[0][0] = true; // 空字符串是可以匹配的
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    m[i][j] = m[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        m[i][j] = m[i][j] || m[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        m[i][j] = m[i - 1][j - 1];
                    }
                }
            }
        }
        return m[sLen][pLen];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
