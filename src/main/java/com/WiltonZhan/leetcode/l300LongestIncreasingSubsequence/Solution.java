package com.WiltonZhan.leetcode.l300LongestIncreasingSubsequence;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution {
    /**
     * 动态规划：
     * 设立一个数组 memo[0...n-1] , 其中 memo[i] 用来存储以 nums[i] 结尾的序列 nums[0...i] 的最长上升子序列。
     * 那么： memo[i] = max{1 + memo[j] if nums[j] < nums[i] while j < i}
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], memo[j]);
                }
            }
            memo[i] = memo[i] + 1;
        }

        int result = -1;
        for (int len: memo) {
            result = Math.max(len, result);
        }
        return result;
    }
}
