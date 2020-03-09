package com.WiltonZhan.leetcode.l121BestTimeToBuyAndSellStock;

/**
 * 动态规划：第i天的最大收益=max{第i-1天的最大收益, 第i天的价格-第i天前最小的价格}
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] profit = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            profit[i] = Math.max(profit[i - 1], prices[i] - minPrice);
        }
        return profit[prices.length - 1];
    }
}
