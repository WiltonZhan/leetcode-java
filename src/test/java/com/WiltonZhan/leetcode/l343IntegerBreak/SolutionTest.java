package com.WiltonZhan.leetcode.l343IntegerBreak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void integerBreak() {
        assertEquals(1, solution.integerBreak(2));
        assertEquals(36, solution.integerBreak(10));
    }
}