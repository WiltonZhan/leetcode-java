package com.WiltonZhan.leetcode.l240SearchA2dMatrixII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void searchMatrix() {
        int[][] maxtrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertTrue(solution.searchMatrix(maxtrix, 5));
        assertFalse(solution.searchMatrix(maxtrix, 20));
    }
}