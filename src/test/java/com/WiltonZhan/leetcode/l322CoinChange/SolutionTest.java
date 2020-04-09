package com.WiltonZhan.leetcode.l322CoinChange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void coinChange() {
        assertEquals(2, solution.coinChange(new int[]{1, Integer.MAX_VALUE}, 2));
        assertEquals(-1, solution.coinChange(new int[]{Integer.MAX_VALUE}, 2));
        assertEquals(0, solution.coinChange(new int[]{1}, 0));
        assertEquals(3, solution.coinChange(new int[]{1,2,5}, 11));
        assertEquals(-1, solution.coinChange(new int[]{3}, 2));
        assertEquals(-1, solution.coinChange(new int[]{3,5}, 7));
    }
}