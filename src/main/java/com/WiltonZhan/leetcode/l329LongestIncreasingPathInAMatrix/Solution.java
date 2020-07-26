package com.WiltonZhan.leetcode.l329LongestIncreasingPathInAMatrix;

/*
329. 矩阵中的最长递增路径
给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

示例 1:

输入: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
输出: 4
解释: 最长递增路径为 [1, 2, 6, 9]。
示例 2:

输入: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
输出: 4
解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */
public class Solution {
    private final int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /**
     *  采用记忆化深度优先搜索
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, rows, cols, memo));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int row, int col, int rows, int cols, int[][] memo) {
        if (memo[row][col] != 0) {
            // 已经搜索过
            return memo[row][col];
        }
        memo[row][col]++;
        for (int[] direction: directions) {
            int newRow = row + direction[0], newCol = col + direction[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]) {
                memo[row][col] = Math.max(memo[row][col], dfs(matrix, newRow, newCol, rows, cols, memo) + 1);
            }
        }

        return memo[row][col];
    }
}
