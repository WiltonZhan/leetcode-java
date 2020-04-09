package com.WiltonZhan.leetcode.l322CoinChange;

import java.util.Arrays;

/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int[] memo = new int[amount + 1];
        memo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int count = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (i >= coin && memo[i - coin] != -1) {
                    count = Math.min(count, memo[i - coin] + 1);
                }
            }
            memo[i] = count == Integer.MAX_VALUE ? -1 : count;
        }

        return memo[amount];
    }

    public int coinChange_with_sort(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (coins[0] > amount) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        memo[0] = 0;
        for (int i = 1; i < coins[0]; i++) {
            memo[i] = -1;
        }

        for (int coin: coins) {
            if (coin <= amount) {
                memo[coin] = 1;
            }
        }

        for (int i = coins[0] + 1; i <= amount; i++) {
            int count = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (i >= coin && memo[i - coin] != -1) {
                    count = Math.min(count, memo[i - coin] + 1);
                }
            }
            memo[i] = count == Integer.MAX_VALUE ? -1 : count;
        }

        return memo[amount];
    }
}
