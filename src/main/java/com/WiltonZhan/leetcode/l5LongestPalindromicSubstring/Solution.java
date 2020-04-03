package com.WiltonZhan.leetcode.l5LongestPalindromicSubstring;

public class Solution {
    /**
     * 方法1
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
     * 方法2
     *  动态规划：考虑每个长度为len的从下标i开始的子串，如果s[i+1...i+len-2]为回文串并且s[i]==s[i+len-1]，那么s[i..i+len-1]也是回文串。
     *  长度为1和长度为2的子串需要单独考虑
     */
    public String longestPalindrome_dp(String s) {
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

    /**
     * 方法2改进
     */
    public String longestPalindrome_dp2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int slen = s.length();
        int start = 0, maxLen = 1;
        boolean[][] isPalindromes = new boolean[slen + 1][slen];

        for (int i = 0; i < slen; i++) {    // 长度为1的子串都是回文串
            isPalindromes[1][i] = true;
        }

        for (int i = 0; i < slen - 1; i++) {    // 处理长度为2的子串
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindromes[2][i] = true;
                start = i;
                maxLen = 2;
            }
        }

        for (int len = 3; len < slen + 1; len++) {  // 处理长度为3~slen的子串
            for (int i = 0; i <= slen - len; i++) {
                if (isPalindromes[len - 2][i + 1] && s.charAt(i) == s.charAt(i + len - 1)) {
                    isPalindromes[len][i] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     *  方法3：以某一个为1或长度为2子串为中心，向两侧扩展
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int left = 0, right = 0, maxLen = 1;
        int slen = s.length();
        for (int i = 0; i < slen; i++) {
            for (int l = i, r = i; l >= 0 && r < slen;l--,r++) {    // 以i为中心
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > maxLen) {
                        left = l;
                        right = r;
                        maxLen = r - l + 1;
                    }
                } else {
                    break;
                }
            }

            if (i + 1 < slen && s.charAt(i) == s.charAt(i + 1)) {   // 以[i,j]为中心
                for (int l = i, r = i + 1; l >= 0 && r < slen; l--,r++) {
                    if (s.charAt(l) == s.charAt(r)) {
                        if (r - l + 1 > maxLen) {
                            left = l;
                            right = r;
                            maxLen = r - l + 1;
                        }
                    } else {
                        break;
                    }
                }
            }

        }

        return s.substring(left, right + 1);
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
