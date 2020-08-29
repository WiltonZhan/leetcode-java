package com.WiltonZhan.leetcode.l1275FindWinnerOnATicTacToeGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void tictactoe() {
        assertEquals("A", solution.tictactoe(new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}}));
        assertEquals("B", solution.tictactoe(new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}}));
        assertEquals("Draw", solution.tictactoe(new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
        assertEquals("Pending", solution.tictactoe(new int[][]{{0,0},{1,1}}));
    }
}