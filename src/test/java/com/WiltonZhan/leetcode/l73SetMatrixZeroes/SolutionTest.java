package com.WiltonZhan.leetcode.l73SetMatrixZeroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void setZeroes() {
        int[][] matrix1 = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix1);
        assertArrayEquals(matrix1[0], new int[]{1,0,1});
        assertArrayEquals(matrix1[1], new int[]{0,0,0});
        assertArrayEquals(matrix1[2], new int[]{1,0,1});

        int[][] matrix2 = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes(matrix2);
        assertArrayEquals(matrix2[0], new int[]{0,0,0,0});
        assertArrayEquals(matrix2[1], new int[]{0,4,5,0});
        assertArrayEquals(matrix2[2], new int[]{0,3,1,0});
    }
}