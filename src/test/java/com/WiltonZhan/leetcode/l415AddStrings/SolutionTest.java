package com.WiltonZhan.leetcode.l415AddStrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void addStrings() {
        assertEquals("13", solution.addStrings("10", "3"));
        assertEquals("100", solution.addStrings("91", "9"));
    }
}