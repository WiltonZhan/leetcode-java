package com.WiltonZhan.leetcode.l200NumberOfIslands;

import java.util.ArrayDeque;
import java.util.Queue;

/*
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islands = 0;
        Queue<Integer> xqueue = new ArrayDeque<>();
        Queue<Integer> yqueue = new ArrayDeque<>();
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (grid[i][j] == '1') {
                        xqueue.offer(i);
                        yqueue.offer(j);
                        visited[i][j] = true;
                        while (!xqueue.isEmpty() && !yqueue.isEmpty()) {
                            int x = xqueue.poll();
                            int y = yqueue.poll();
                            if (x - 1 >= 0 && !visited[x - 1][y] && grid[x - 1][y] == '1') {
                                xqueue.offer(x - 1);
                                yqueue.offer(y);
                                visited[x - 1][y] = true;
                            }
                            if (x + 1 < rows && !visited[x + 1][y] && grid[x + 1][y] == '1') {
                                xqueue.offer(x + 1);
                                yqueue.offer(y);
                                visited[x + 1][y] = true;
                            }
                            if (y - 1 >= 0 && !visited[x][y - 1] && grid[x][y - 1] == '1') {
                                xqueue.offer(x);
                                yqueue.offer(y - 1);
                                visited[x][y - 1] = true;
                            }
                            if (y + 1 < cols && !visited[x][y + 1] && grid[x][y + 1] == '1') {
                                xqueue.offer(x);
                                yqueue.offer(y + 1);
                                visited[x][y + 1] = true;
                            }
                        }
                        islands++;
                    }
                }
            }
        }

        return islands;
    }
}
