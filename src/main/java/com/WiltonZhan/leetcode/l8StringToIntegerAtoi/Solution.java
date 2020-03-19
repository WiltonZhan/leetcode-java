package com.WiltonZhan.leetcode.l8StringToIntegerAtoi;

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        int i = 0;
        while(i < len && (str.charAt(i) <= ' ')) {  // 去前面空格
            i++;
        }
        String trimmedStr = str.substring(i, len);
        boolean negative = false;
        long result = 0;
        int digit;
        i = 0;
        len = trimmedStr.length();
        if (len > 0) {
            char firstChar = trimmedStr.charAt(0);
            if (firstChar == '-') {
                negative = true;
                i++;
            } else if (firstChar == '+') {
                i++;
            } else if (Character.isDigit(firstChar)) {
                // nothing
            } else {
                return 0;
            }
            if (len == 1 && !Character.isDigit(firstChar)) { // 只有正负号
                return 0;
            }
        }
        while(i < len) {
            char c = trimmedStr.charAt(i);
            if(Character.isDigit(c)) {
                digit = Character.digit(trimmedStr.charAt(i++), 10);
                result *= 10;
                result -= digit;
                if (result < Integer.MIN_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }
        if (negative) {
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) result;
        } else {
            if (result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)-result;
        }
    }
}
