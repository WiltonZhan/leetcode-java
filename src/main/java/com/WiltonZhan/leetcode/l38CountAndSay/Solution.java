package com.WiltonZhan.leetcode.l38CountAndSay;

class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        for(int i = 1; i < n; i++) {
            result = countAndSay(result);
        }
        return result.toString();
    }

    private StringBuilder countAndSay(StringBuilder s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() == 0) {
            return sb;
        }

        int i = 0;
        int count = 1;
        int len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            for(; i < len - 1 && s.charAt(i+1) == c; i++) {
                count++;
            }
            sb.append(count).append(c);
            i++;
            count = 1;
        }
        return sb;
    }
}