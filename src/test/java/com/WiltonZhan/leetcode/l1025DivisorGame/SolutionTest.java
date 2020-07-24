package com.WiltonZhan.leetcode.l1025DivisorGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void divisorGame() {
        assertTrue(solution.divisorGame(2));
        assertFalse(solution.divisorGame(3));
        assertTrue(solution.divisorGame(4));
        assertFalse(solution.divisorGame(5));
        assertTrue(solution.divisorGame(6));
    }
}