package com.WiltonZhan.leetcode.l718MaximumLengthOfRepeatedSubarray;

/*
718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

示例 1:

输入:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出: 3
解释:
长度最长的公共子数组是 [3, 2, 1]。
说明:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 */
public class Solution {
    /**
     * 暴力解法：枚举数组A和B中所有的下标，问题可以转换为求：子数组A[i:]和B[j:]的最大公共前缀
     * 超时
     */
    public int findLength_brute_force(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int k = 0;  // 最大公共前缀的长度
                while (i + k < A.length && j + k < B.length && A[i + k] == B[j + k]) {
                    k++;
                }
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }

    /**
     * 动态规划：dp[i][j]表示子数组A[i:]和B[j:]的最大公共前缀的长度。若A[i] == B[j]，则dp[i][j] = dp[i+1][j+1] + 1
     */
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }

        int ans = 0;
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }

        return ans;
    }
}
