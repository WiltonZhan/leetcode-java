package com.WiltonZhan.leetcode.l28ImplementStrstr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void strStr() {
        assertEquals(2, solution.strStr("hello", "ll"));
        assertEquals(0, solution.strStr("hello", ""));
        assertEquals(-1, solution.strStr("aaaa", "bba"));
    }
}