package com.WiltonZhan.leetcode.l125ValidPalindrome;

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        for(int left = 0, right = s.length() - 1; left < right;) {
            while (!(Character.isLetterOrDigit(s.charAt(left))) && left < right) {
                left++;
            }
            while(!Character.isLetterOrDigit(s.charAt(right)) && right > left) {
                right--;
            }
            if (Character.toUpperCase(s.charAt(left)) == Character.toUpperCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
