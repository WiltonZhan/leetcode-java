package com.WiltonZhan.leetcode.l14LongestCommonPrefix;

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
