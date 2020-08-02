package com.WiltonZhan.leetcode.l896MonotonicArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isMonotonic() {
        assertTrue(solution.isMonotonic(new int[]{1,2,2,3}));
        assertTrue(solution.isMonotonic(new int[]{6,5,4,4}));
        assertFalse(solution.isMonotonic(new int[]{1,3,2}));
        assertTrue(solution.isMonotonic(new int[]{1,2,4,5}));
        assertTrue(solution.isMonotonic(new int[]{1,1,1}));
    }
}