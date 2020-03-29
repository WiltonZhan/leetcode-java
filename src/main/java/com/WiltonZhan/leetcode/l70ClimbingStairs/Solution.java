package com.WiltonZhan.leetcode.l70ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            memo[0] = 1;
            memo[1] = 2;
            for(int i = 2; i < n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
            return memo[n - 1];
        }
    }
}
