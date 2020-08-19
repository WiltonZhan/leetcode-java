package com.WiltonZhan.leetcode.l647PalindromicSubStrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void countSubstrings() {
        assertEquals(3, solution.countSubstrings("abc"));
        assertEquals(6, solution.countSubstrings("aaa"));
    }
}