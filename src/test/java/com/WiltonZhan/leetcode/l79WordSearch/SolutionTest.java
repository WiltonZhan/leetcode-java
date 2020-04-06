package com.WiltonZhan.leetcode.l79WordSearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void exist() {
        char[][] board1 = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        assertTrue(solution.exist(board1, "ABCCED"));
        assertTrue(solution.exist(board1, "SEE"));
        assertFalse(solution.exist(board1, "ABCB"));

        char[][] board2 = new char[][]{{'a'}};
        assertTrue(solution.exist(board2, "a"));
    }
}