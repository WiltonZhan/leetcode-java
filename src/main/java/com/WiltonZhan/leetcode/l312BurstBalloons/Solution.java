package com.WiltonZhan.leetcode.l312BurstBalloons;

/*
312. 戳气球
有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:

输入: [3,1,5,8]
输出: 167
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class Solution {
    /**
     * 动态规划：用dp[i][j]表示戳破(i,j)之间的气球能获得硬币的最大数量，则问题转化为求dp[0][n]。
     * 考虑(i,j)之间的k点（k为最后被戳破的气球，那个时候和k相邻的就是i和j了），则dp[i][j] = dp[i][k] + nums[k-1] * nums[i] * nums[j] + dp[k][j]。
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] vals = new int[n + 2];
        vals[0] = 1;
        vals[n + 1] = 1;
        System.arraycopy(nums, 0, vals, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        // i从下往上
        for (int i = n; i >= 0; i--) {
            // j从左往右
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + vals[i] * vals[k] * vals[j] + dp[k][j]);
                }
            }
        }

        return dp[0][n + 1];
    }
}
