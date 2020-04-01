package com.WiltonZhan.leetcode.l73SetMatrixZeroes;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * O(m+n)的额外空间
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();
        int rows = matrix.length, cols = matrix[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    zeroRows.add(r);
                    zeroCols.add(c);
                }
            }
        }

        for (int r: zeroRows) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = 0;
            }
        }

        for (int c : zeroCols) {
            for (int r = 0; r < rows; r++) {
                matrix[r][c] = 0;
            }
        }
    }
}
