package com.WiltonZhan.leetcode.l326PowerOfThree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isPowerOfThree() {
        assertTrue(solution.isPowerOfThree(1));
        assertTrue(solution.isPowerOfThree(27));
        assertFalse(solution.isPowerOfThree(0));
        assertTrue(solution.isPowerOfThree(9));
        assertFalse(solution.isPowerOfThree(45));
    }
}