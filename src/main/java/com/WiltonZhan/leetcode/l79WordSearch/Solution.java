package com.WiltonZhan.leetcode.l79WordSearch;

/*
定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。.



示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false


提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */
public class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0} ,{0, -1}}; // 方向

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (searchWord(board, r, c, 0, visited, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, int r, int c, int pos, boolean[][] visited, String word) {
        if (pos == word.length() - 1) {
            return board[r][c] == word.charAt(pos);
        }

        if (board[r][c] == word.charAt(pos)) {
            visited[r][c] = true;
            for (int[] direction : directions) {
                int x = r + direction[0];
                int y = c + direction[1];
                if (0 <= x && x < visited.length && 0 <= y && y < visited[0].length && !visited[x][y]) {
                    if (searchWord(board, x, y, pos + 1, visited, word)) {
                        return true;
                    }
                }
            }
            visited[r][c] = false;  // backtrack
        }
        return false;
    }
}
