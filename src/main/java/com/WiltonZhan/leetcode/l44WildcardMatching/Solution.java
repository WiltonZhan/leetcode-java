package com.WiltonZhan.leetcode.l44WildcardMatching;

/*
44. 通配符匹配
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。
示例 3:

输入:
s = "cb"
p = "?a"
输出: false
解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
示例 4:

输入:
s = "adceb"
p = "*a*b"
输出: true
解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
示例 5:

输入:
s = "acdcb"
p = "a*c?b"
输出: false
 */
public class Solution {
    /**
     * 动态规划：用 dp[i][j]表示字符串s的前i个字符和模式p的前j个字符是否能匹配
     * 考虑模式的p的第j个字符p[j]，与之对应的是字符串s的第i个字符s[i]：
     *  1. 若p[j]为小写字母，则s[i]也必须为小写字母，即: dp[i][j] = dp[i-1][j-1] && s[i] == p[j]
     *  2. 若p[j]为'?'，则对s[i]没有任何要求，即: dp[i][j] = dp[i][j] = dp[i-1][j-1]
     *  3. 若p[j]为'*‘，则也对s[i]没有任何要求，但由于'*’可以匹配零或任意多个字母，所以要分为两种情况：
     *      3.1. '*'匹配0个字母: dp[i][j] = dp[i][j-1]
     *      3.2. '*'匹配任意多个字符: dp[i][j] = dp[i-1][j]
     *     因此，这种情况下： dp[i][j] = dp[i][j-1] or dp[i-1][j]
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            // 因为‘*’可以匹配任意多个字母，所有只有当p的前缀全都是'*'时，dp[0][j]才为true
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
