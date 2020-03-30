package com.WiltonZhan.leetcode.l204CountPrimes;

public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
            }
            for (int j = i * 2; j < n; j += i) {
                notPrimes[j] = true;
            }
        }

        return count;
    }
}
