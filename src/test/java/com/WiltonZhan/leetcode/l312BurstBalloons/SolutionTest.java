package com.WiltonZhan.leetcode.l312BurstBalloons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void maxCoins() {
        assertEquals(167, solution.maxCoins(new int[]{3,1,5,8}));
    }
}