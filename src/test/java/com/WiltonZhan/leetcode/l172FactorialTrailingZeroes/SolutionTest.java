package com.WiltonZhan.leetcode.l172FactorialTrailingZeroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void trailingZeroes() {
        assertEquals(452137076, solution.trailingZeroes(1808548329));
        assertEquals(0, solution.trailingZeroes(3));
        assertEquals(1, solution.trailingZeroes(5));
        assertEquals(2, solution.trailingZeroes(11));
    }
}