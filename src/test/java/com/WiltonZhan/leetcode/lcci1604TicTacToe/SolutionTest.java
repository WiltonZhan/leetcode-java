package com.WiltonZhan.leetcode.lcci1604TicTacToe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void tictactoe() {
        assertEquals("X", solution.tictactoe(new String[]{"X O O"," X   ","OOXO ","O  X ","X   X"}));
        assertEquals("X", solution.tictactoe(new String[]{"O X"," XO","X O"}));
        assertEquals("Draw", solution.tictactoe(new String[]{"OOX","XXO","OXO"}));
        assertEquals("Pending", solution.tictactoe(new String[]{"OOX","XXO","OX "}));
    }
}