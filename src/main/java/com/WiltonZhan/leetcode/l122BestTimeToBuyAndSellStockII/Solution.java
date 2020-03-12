package com.WiltonZhan.leetcode.l122BestTimeToBuyAndSellStockII;

/**
 * 画出股票价格的趋势图，在波谷买入，波峰卖出。不断循环这个过程
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int i = 0;
        int maxProfit = 0;
        while (i < prices.length) {
            while(i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            int low = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            int high = prices[i];
            maxProfit += high - low;
            i++;
        }
        return maxProfit;
    }
}
