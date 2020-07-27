package com.WiltonZhan.leetcode.l392IsSubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isSubsequence() {
        assertTrue(solution.isSubsequence("", "ahbgdc"));
        assertTrue(solution.isSubsequence("abc", "ahbgdc"));
        assertFalse(solution.isSubsequence("axc", "ahbgdc"));
    }
}