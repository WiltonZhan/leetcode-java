package com.WiltonZhan.leetcode.l696CountBinarySubstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void countBinarySubstrings() {
        assertEquals(6, solution.countBinarySubstrings("00110011"));
        assertEquals(4, solution.countBinarySubstrings("10101"));
    }
}