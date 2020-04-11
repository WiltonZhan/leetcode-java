package com.WiltonZhan.leetcode.l202HappyNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isHappy() {
        assertTrue(solution.isHappy(19));
        assertTrue(solution.isHappy(7));
        assertFalse(solution.isHappy(116));
    }
}