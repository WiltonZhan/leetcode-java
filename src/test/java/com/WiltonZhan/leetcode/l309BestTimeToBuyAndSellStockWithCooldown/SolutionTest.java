package com.WiltonZhan.leetcode.l309BestTimeToBuyAndSellStockWithCooldown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void maxProfit() {
        assertEquals(3, solution.maxProfit(new int[]{1,2,3,0,2}));
    }
}