package com.WiltonZhan.leetcode.l130SurroundedRegions;

/*
130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solution {
    /**
     * 先找出所有和边界上得'O'连通得'O‘，将其变成'E'，然后将剩余得'O'变为'X'，最后将'E'还原成'O'
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length, cols = board[0].length;
        // Flood-Fill edge
        for (int r = 0; r < rows; r++) {
            floodFill(board, r, 0, 'O', 'E');
            floodFill(board, r, cols - 1, 'O', 'E');
        }
        for (int c = 0; c < cols; c++) {
            floodFill(board, 0, c, 'O', 'E');
            floodFill(board, rows - 1, c, 'O', 'E');
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                floodFill(board, r, c, 'O', 'X');
            }
        }

        // recover
        for (int r = 0; r < rows; r++) {
            floodFill(board, r, 0, 'E', 'O');
            floodFill(board, r, cols - 1, 'E', 'O');
        }
        for (int c = 0; c < cols; c++) {
            floodFill(board, 0, c, 'E', 'O');
            floodFill(board, rows - 1, c, 'E', 'O');
        }
    }

    private void floodFill(char[][] board, int r, int c, char oldChar, char newChar) {
        if (0 <= r && r < board.length && 0 <= c && c < board[0].length && board[r][c] == oldChar) {
            board[r][c] = newChar;
            floodFill(board, r - 1, c, oldChar, newChar);
            floodFill(board, r + 1, c, oldChar, newChar);
            floodFill(board, r, c - 1, oldChar, newChar);
            floodFill(board, r, c + 1, oldChar, newChar);
        }
    }
}
