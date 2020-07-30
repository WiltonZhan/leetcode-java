package com.WiltonZhan.leetcode.l343IntegerBreak;

/*
343. 整数拆分
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Solution {
    /**
     * 动态规划
     * 用product[i]表示整数i被拆分后的最大乘积。考虑整数j（1 <= j < i），则product[i] = max{max{j,product[j]} * (i - j)}
     */
    public int integerBreak(int n) {
        int[] product = new int[n + 1];
        product[0] = 1;
        product[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                product[i] = Math.max(product[i], Math.max(j, product[j]) * (i - j));
            }
        }
        return product[n];
    }
}
