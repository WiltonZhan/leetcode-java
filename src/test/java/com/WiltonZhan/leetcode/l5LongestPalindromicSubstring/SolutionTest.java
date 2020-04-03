package com.WiltonZhan.leetcode.l5LongestPalindromicSubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void longestPalindrome() {
        assertEquals("bab", solution.longestPalindrome("babad"));
        assertEquals("babab", solution.longestPalindrome("babab"));
        assertEquals("bb", solution.longestPalindrome("cbbd"));
        assertEquals("aa", solution.longestPalindrome("aa"));
        assertSame("a", solution.longestPalindrome("a"));
    }
}