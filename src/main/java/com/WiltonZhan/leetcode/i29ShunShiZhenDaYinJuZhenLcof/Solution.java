package com.WiltonZhan.leetcode.i29ShunShiZhenDaYinJuZhenLcof;

import java.util.Arrays;

/*
面试题29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。



示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]


限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Solution {
    /**
     *  模拟顺时针遍历的过程，不断调整四个方向的边界
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int idx = 0;

        int up = 0, down = rows - 1, left = 0, right = cols - 1;    // 边界
        int r = 0, c = 0;   // 当前位置
        while (up <= down && left <= right) {
            for (; c <= right; c++) {
                result[idx++] = matrix[r][c];
            }
            up++;
            r++;
            if (r > down) {
                break;
            }
            c--;

            for (; r <= down; r++) {
                result[idx++] = matrix[r][c];
            }
            right--;
            c--;
            if (c < left) {
                break;
            }
            r--;

            for (; c >= left; c--) {
                result[idx++] = matrix[r][c];
            }
            down--;
            r--;
            if (r < up) {
                break;
            }
            c++;

            for (; r >= up; r--) {
                result[idx++] = matrix[r][c];
            }
            left++;
            c++;
            if (c > right) {
                break;
            }
            r++;
        }

        return result;
    }
}
