package com.WiltonZhan.leetcode.l48RotateImage;

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length;
        int cycles = n / 2;
        for (int c = 0; c < cycles; c++) {
            for (int i = c; i < n - 1 - c; i++) {
                int topLeft = matrix[c][i];
                int topRight = matrix[i][n - 1 - c];
                int bottomRight = matrix[n - 1 - c][n - 1 - i];
                int bottomLeft = matrix[n - 1 - i][c];
                matrix[c][i] = bottomLeft;
                matrix[i][n - 1 - c] = topLeft;
                matrix[n - 1 - c][n - 1 - i] = topRight;
                matrix[n - 1 - i][c] = bottomRight;
            }
        }
    }
}
