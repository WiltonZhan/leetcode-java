package com.WiltonZhan.leetcode.l529Minesweeper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void updateBoard() {
        char[][] board1 = new char[][]{
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        };
        char[][] board2 = new char[][]{
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'X', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}

        };

        board1 = solution.updateBoard(board1, new int[]{1, 2});
        for (int i = 0; i < board1.length; i++) {
            assertArrayEquals(board2[i], board1[i]);
        }

        char[][] board3 = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        char[][] board4 = new char[][]{
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        };
        board3 = solution.updateBoard(board3, new int[]{3, 0});
        for (int i = 0; i < board3.length; i++) {
            assertArrayEquals(board4[i], board3[i]);
        }
    }
}