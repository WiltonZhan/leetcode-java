package com.WiltonZhan.leetcode.l63UniquePathsII;

/*
63. 不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Solution {
    /**
     *  动态规划：使用paths[i][j]表示到obstacleGrid[i][j]的路径数，则：
     *  if ((obstacleGrid[i][j-1] == 1 and obstacleGrid[i-1][j] == 1) or obstacleGrid[i][j] == 1), then paths[i][j] = 0;
     *  else paths[i][j] = paths[i-1][j] + paths[i][j-1]
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0] == null) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;  // 第一行后面的都不可达
            } else {
                paths[0][j] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;  // 第一列后面的都不可达
            } else {
                paths[i][0] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if ((obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) || obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}
