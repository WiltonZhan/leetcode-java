package com.WiltonZhan.leetcode.l6ZigzagConversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void convert() {
        assertEquals("LCIRETOESIIGEDHN", solution.convert("LEETCODEISHIRING", 3));
        assertEquals("LDREOEIIECIHNTSG", solution.convert("LEETCODEISHIRING", 4));
    }
}