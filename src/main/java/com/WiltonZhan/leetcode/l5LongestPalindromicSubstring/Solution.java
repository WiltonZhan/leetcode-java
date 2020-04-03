package com.WiltonZhan.leetcode.l5LongestPalindromicSubstring;

public class Solution {
    /**
     * 暴力求解：会超时
     */
    public String longestPalindrome_brute_force(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String result = "";
        int len = 0;
        for (int i = 0; i < s.length();i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > len) {
                        len = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }

        return result;
    }

    /**
     *  动态规划：考虑每个长度为len的从下标i开始的子串，如果s[i+1...i+len-2]为回文串并且s[i]==s[i+len-1]，那么s[i..i+len-1]也是回文串。
     *  长度为1和长度为2的子串需要单独考虑
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int slen = s.length();
        boolean[][] isPalindromes = new boolean[slen + 1][slen];
        for (int len = 1; len < slen + 1; len++) {
            for (int i = 0; i <= slen - len; i++) {
                if (len == 1) {
                    isPalindromes[len][i] = true;
                } else if (len == 2) {
                    if (s.charAt(i) == s.charAt(i + 1)) {
                        isPalindromes[len][i] = true;
                    }
                } else {
                    if (isPalindromes[len - 2][i + 1] && s.charAt(i) == s.charAt(i + len - 1)) {
                        isPalindromes[len][i] = true;
                    }
                }
            }
        }

        for (int len = slen; len > 0; len--) {
            for (int i = 0; i < slen; i++) {
                if (isPalindromes[len][i]) {
                    return s.substring(i, i + len);
                }
            }
        }

        return s.substring(0, 1);
    }

    private boolean isPalindrome(String s, int l, int r) {
        if (s == null || s.length() == 0 || l > r || l > s.length()) {
            return false;
        }

        while(l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
