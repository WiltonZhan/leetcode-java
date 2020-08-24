package com.WiltonZhan.leetcode.l459RepeatedSubstringPattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void repeatedSubstringPattern() {
        assertTrue(solution.repeatedSubstringPattern("aaa"));
        assertTrue(solution.repeatedSubstringPattern("abab"));
        assertFalse(solution.repeatedSubstringPattern("aba"));
        assertTrue(solution.repeatedSubstringPattern("abcabcabc"));
    }
}