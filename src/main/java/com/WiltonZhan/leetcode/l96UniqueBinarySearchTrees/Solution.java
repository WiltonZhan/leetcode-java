package com.WiltonZhan.leetcode.l96UniqueBinarySearchTrees;

/*
96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class Solution {
    /**
     * 动态规划：将整数k(1<=k<=n)作为根节点，[1..k-1]构建左子树，[k+1..n]构建右子树。
     *  则：以k为根节点的BST的种数有：左子树能形成的BST个数 * 右子树能形成的BST个数。
     *  用dp[i]表示[1..i]能形成的BST个数，则：dp[i] = Σ(dp[j] * dp[i-j-1]), 0<=j<=i-1
     */
    public int numTrees(int n) {
        if (n < 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
