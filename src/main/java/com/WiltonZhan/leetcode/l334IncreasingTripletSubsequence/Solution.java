package com.WiltonZhan.leetcode.l334IncreasingTripletSubsequence;

/*
给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

数学表达式如下:

如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 */
public class Solution {
    /**
     * 维护一个较小值min和一个中间值mid。在遍历过程中，不断更新这两个值。
     * 为什么在更新min不会出问题：因为min只有可能变小，而且mid也总是大于min的
     *
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > min && num < mid) {
                mid = num;
            } else if (num > mid) {
                return true;
            }
        }

        return false;
    }
}
