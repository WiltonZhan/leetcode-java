package com.WiltonZhan.leetcode.l204CountPrimes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void countPrimes() {
        assertEquals(0, solution.countPrimes(2));
        assertEquals(4, solution.countPrimes(10));
        assertEquals(41537, solution.countPrimes(499979));
    }
}