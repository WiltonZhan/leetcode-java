package com.WiltonZhan.leetcode.l48RotateImage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void rotate() {
        int[][] matrix1 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        int[][] matrix2 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        solution.rotate(matrix1);
        solution.rotate(matrix2);
    }
}