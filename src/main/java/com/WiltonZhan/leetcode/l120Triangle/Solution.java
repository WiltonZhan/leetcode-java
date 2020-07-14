package com.WiltonZhan.leetcode.l120Triangle;

import java.util.ArrayList;
import java.util.List;

/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Solution {
    /**
     * 动态规划
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        int n = triangle.size();
        int[] pathSum = new int[n];
        pathSum[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            // 用temp保存被覆盖掉的那个值pathSum[j-1]
            int temp = pathSum[0];
            pathSum[0] += triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                int temp2 = pathSum[j];
                pathSum[j] = Math.min(pathSum[j], temp) + triangle.get(i).get(j);
                temp = temp2;
            }
            pathSum[i] = temp + triangle.get(i).get(i);
        }
        int minPathSum = pathSum[0];
        for (int i = 1; i < n; i++) {
            minPathSum = Math.min(minPathSum, pathSum[i]);
        }

        return minPathSum;
    }
}
