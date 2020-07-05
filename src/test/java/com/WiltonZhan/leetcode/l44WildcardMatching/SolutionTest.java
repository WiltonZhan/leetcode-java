package com.WiltonZhan.leetcode.l44WildcardMatching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isMatch() {
        assertFalse(solution.isMatch("aa", "a"));
        assertTrue(solution.isMatch("aa", "*"));
        assertFalse(solution.isMatch("cb", "?a"));
        assertTrue(solution.isMatch("adceb", "*a*b"));
        assertFalse(solution.isMatch("acdcb", "a*c?b"));
    }
}