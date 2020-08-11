package com.WiltonZhan.leetcode.l130SurroundedRegions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void solve() {
        char[][] board0 = new char[][]{{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution.solve(board0);
        char[][] board1 = new char[][]{{'X', 'X', 'X', 'X'},{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};
        for (int i = 0; i < board0.length; i++) {
            assertArrayEquals(board0[i], board1[i]);
        }
    }

}