package com.WiltonZhan.leetcode.l172FactorialTrailingZeroes;

/*
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:

输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。
示例 2:

输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.
说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class Solution {
    /**
     * 只有两种情况可能出现0，一是10的倍数，二是5乘以一个偶数。而10=5*2，其实最终可以转化为能找出多少个5*2。
     * 由于一个5至少往下会有两个2（2和4），所以问题最终转化为找n!中5出现的次数。
     *
     *
     */
    public int trailingZeroes(int n) {
        int zeroes = 0;
        while(n > 0) {
            zeroes += n / 5;
            n /= 5;
        }

        return zeroes;
    }
}
