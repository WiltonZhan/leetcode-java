package com.WiltonZhan.leetcode.l647PalindromicSubStrings;

/*
647. 回文子串
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。



示例 1：

输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"


提示：

输入的字符串长度不会超过 1000 。
 */
public class Solution {
    /**
     * 动态规划。用dp[i][j]表示s[i..j]是否为回文子串，则：
     * 1. s[i][i] = true
     * 2. if (s[i] == s[i+1]) then s[i][i+1] = true
     * 3. if (s[i] == s[j] && s[i+1..j-1] is a palindrome) then s[i][j] = true
     *
     * 由于i<=j，我们只需要填充对角线以下部分的矩阵，填充顺序为从右到左，从上到下
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;
        int ans = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            ans++;
            if(i + 1 < len && chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                ans++;
            }
        }

        for (int j = 2; j < len; j++) {
            for (int i = j - 2; i >= 0; i--) {
                if (chars[i] == chars[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
