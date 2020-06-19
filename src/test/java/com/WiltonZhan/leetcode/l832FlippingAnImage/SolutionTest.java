package com.WiltonZhan.leetcode.l832FlippingAnImage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void flipAndInvertImage() {
        int[][] A1 = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int[][] B1 = new int[][]{{1,0,0},{0,1,0},{1,1,1}};
        A1 = solution.flipAndInvertImage(A1);
        for (int i = 0; i < A1.length; i++) {
            assertArrayEquals(A1[i], B1[i]);
        }

        int[][] A2 = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int [][] B2 = new int[][]{{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}};
        A2 = solution.flipAndInvertImage(A2);
        for (int i = 0; i < A2.length; i++) {
            assertArrayEquals(A2[i], B2[i]);
        }
    }
}