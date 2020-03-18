package com.WiltonZhan.leetcode.l125ValidPalindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isPalindrome() {
        assertFalse(solution.isPalindrome("0P"));
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(solution.isPalindrome("race a car"));
    }
}