package com.WiltonZhan.leetcode.l209MininumSizeSubarraySum;

/*
209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。

示例:

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Solution {
    /**
     *  采用双指针维护一个滑动窗口，若窗口内的子数组和小于s，右边界右移。否则更新长度并向右移动左边界
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int l = 0, r = -1; r - l + 1 >= 0;) {
            if (sum < s) {
                if (r + 1 < nums.length) {
                    sum += nums[++r];
                } else {
                    break;
                }
            } else {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
