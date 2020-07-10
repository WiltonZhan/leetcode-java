package com.WiltonZhan.leetcode.l309BestTimeToBuyAndSellStockWithCooldown;

/*
309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Solution {
    /**
     * 动态规划：用dp[i]表示第i天结束之后的[累计最大收益]。根据题目描述，第i天可能处于三种不同的状态：
     *  1. 持有一只股票,记对应的[累计最大收益]为：dp[i][0]
     *  2. 不持有股票并且处于冷冻期，记对应的[累计最大收益]为：dp[i][1]
     *  3. 不持有股票且不处于冷冻期，记对应的[累计最大收益]为：dp[i][2]
     *
     * 在第i天，我们可以根据规则进行买入还卖出操作，此时第i天的状态就从第i-1天转移而来；我们以可以啥都不干，此时第i天的状态与第i-1天的状态相同，对三种状态进行分析：
     *  1. 持有一只股票：因为冷冻期的存在，所以这个股票要么是第i-1天就已经持有的，要么就是第i天刚购买的，那么dp[i][0] = max{dp[i-1][0], dp[i-1][2] - prices[i]}
     *  2. 不持有股票且处于冷冻期内：第i-1天肯定持有一只股票，然后第i天卖出，所以dp[i][1] = dp[i-1][0] + prices[i]
     *  3. 不持有股票且不处于冷冻期内：这要看第i-1天是否处于冷冻期了，dp[i][2] = max{dp[i-1][1], dp[i-1][2]}
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
