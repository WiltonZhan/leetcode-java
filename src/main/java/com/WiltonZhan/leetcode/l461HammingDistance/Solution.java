package com.WiltonZhan.leetcode.l461HammingDistance;

public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
