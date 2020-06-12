package com.WiltonZhan.leetcode.l70ClimbingStairs;

/*
70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
 */
public class Solution {
    /**
     *  动态规划
     *  空间复杂度：O(n)
     */
    public int climbStairs_01(int n) {
        int[] memo = new int[n];
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            memo[0] = 1;
            memo[1] = 2;
            for(int i = 2; i < n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
            return memo[n - 1];
        }
    }

    /**
     * 动态规划
     * 空间复杂度：O(1)
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
