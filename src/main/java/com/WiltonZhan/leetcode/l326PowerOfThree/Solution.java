package com.WiltonZhan.leetcode.l326PowerOfThree;

public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }

        int three = 3;
        while (three > 0 && three < n) {
            three *= 3;
        }
        return three == n;
    }
}
