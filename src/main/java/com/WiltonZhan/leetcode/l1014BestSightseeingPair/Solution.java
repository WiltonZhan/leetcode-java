package com.WiltonZhan.leetcode.l1014BestSightseeingPair;

/*
1014. 最佳观光组合
给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。

一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

返回一对观光景点能取得的最高分。



示例：

输入：[8,1,5,2,6]
输出：11
解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11


提示：

2 <= A.length <= 50000
1 <= A[i] <= 1000
 */
public class Solution {
    /**
     *  暴力解法：固定i寻找j
     *  超时
     */
    public int maxScoreSightseeingPair_brute_force1(int[] A) {
        int maxScore = Integer.MIN_VALUE;
        if (A == null || A.length == 0) {
            return maxScore;
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int score = A[i] + A[j] + i - j;
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }
        return maxScore;
    }

    /**
     * 暴力解法：固定j寻找i
     */
    public int maxScoreSightseeingPair_brute_force2(int[] A) {
        int maxScore = Integer.MIN_VALUE;
        if (A == null || A.length == 0) {
            return maxScore;
        }

        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < j; i++) {
                int score = A[i] + A[j] + i - j;
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }
        return maxScore;
    }

    /**
     *  单次遍历：A[i] + A[j] + i - j = (A[i] + i) + (A[j] - j)
     *  固定j寻找i：以终点j为参考点，(A[j] - j)是不变的，因此只需要最大化[0, j-1]中的(A[i] + i)并记录即可
    */
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = Integer.MIN_VALUE;
        if (A == null || A.length == 0) {
            return maxScore;
        }

        int mx = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            maxScore = Math.max(maxScore, mx + A[j] - j);
            mx = Math.max(mx, A[j] + j);
        }

        return maxScore;
    }
}
