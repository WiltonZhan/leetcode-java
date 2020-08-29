package com.WiltonZhan.leetcode.l749ValidTicTacToeState;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void validTicTacToe() {
        assertTrue(solution.validTicTacToe(new String[]{"XOX","OOX","XO "}));
        assertFalse(solution.validTicTacToe(new String[]{"OXX","XOX","OXO"}));
        assertFalse(solution.validTicTacToe(new String[]{"O  ", "   ", "   "}));
        assertFalse(solution.validTicTacToe(new String[]{"XOX", " X ", "   "}));
        assertFalse(solution.validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        assertTrue(solution.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    }
}