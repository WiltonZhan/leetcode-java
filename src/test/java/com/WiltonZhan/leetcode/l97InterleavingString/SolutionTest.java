package com.WiltonZhan.leetcode.l97InterleavingString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isInterleave() {
        assertTrue(solution.isInterleave("", "b", "b"));
        assertTrue(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}