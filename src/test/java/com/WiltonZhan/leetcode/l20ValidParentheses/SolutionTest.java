package com.WiltonZhan.leetcode.l20ValidParentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isValid() {
        assertFalse(solution.isValid(")}"));
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("(){}[]"));
        assertFalse(solution.isValid("(]"));
        assertFalse(solution.isValid("([)]"));
        assertTrue(solution.isValid("{()}"));
        assertTrue(solution.isValid("{[()]}"));
    }
}