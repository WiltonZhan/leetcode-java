package com.WiltonZhan.leetcode.l36ValidSudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            int[] table = new int[10];
            for(int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    int key = Character.getNumericValue(board[i][j]);
                    table[key]++;
                    if (table[key] > 1) {
                        return false;
                    }
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            int[] table = new int[10];
            for(int j = 0; j < 9; j++) {
                if (Character.isDigit(board[j][i])) {
                    int key = Character.getNumericValue(board[j][i]);
                    table[key]++;
                    if (table[key] > 1) {
                        return false;
                    }
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int[] table = new int[10];
                for(int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        if(Character.isDigit(board[i * 3 + r][j * 3 + c])) {
                            int key = Character.getNumericValue(board[i * 3 + r][j * 3 + c]);
                            table[key]++;
                            if (table[key] > 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
