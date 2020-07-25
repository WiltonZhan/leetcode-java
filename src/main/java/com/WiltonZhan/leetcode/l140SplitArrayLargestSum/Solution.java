package com.WiltonZhan.leetcode.l140SplitArrayLargestSum;

/*
410. 分割数组的最大值
给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。

注意:
数组长度 n 满足以下条件:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
示例:

输入:
nums = [7,2,5,10,8]
m = 2

输出:
18

解释:
一共有四种方法将nums分割为2个子数组.
其中最好的方式是将其分为[7,2,5] 和 [10,8]，
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */
public class Solution {
    /**
     * 动态规划：用dp[i][j]表示nums[0..i-1]被分成j段所能得到的子数组和的最小值。
     * 考虑第j段的范围，枚举k，其中nums[0..k-1]位于j-1段，nums[k..i-1]位于第j段。
     * 则dp[i][j] = min{max{dp[k][j-1], sum(nums[k, i-1]}}, 0 <= k <= i-1
     * 我们需要找的是枚举k的过程中
     */
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k <= i - 1; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sums[i] - sums[k]));
                }
            }
        }

        return dp[n][m];
    }
}
