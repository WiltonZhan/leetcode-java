package com.WiltonZhan.leetcode.l32LongestValidParentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void longestValidParentheses() {
        assertEquals(2, solution.longestValidParentheses("()(()"));
        assertEquals(2, solution.longestValidParentheses("(()"));
        assertEquals(4, solution.longestValidParentheses("()()"));
    }
}