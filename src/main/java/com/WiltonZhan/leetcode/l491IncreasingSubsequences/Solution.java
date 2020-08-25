package com.WiltonZhan.leetcode.l491IncreasingSubsequences;

import java.util.*;

/*
491. 递增子序列
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> subsequences = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return subsequences;
        }

        dfs(subsequences, new LinkedList<>(), nums, 0, 0, Integer.MIN_VALUE);
        return subsequences;
    }

    private void dfs(List<List<Integer>> subsequences, LinkedList<Integer> subsequence, int[] nums, int idx, int len, int lastNum) {
        if (len >= 2) {
            subsequences.add(new LinkedList<>(subsequence));
        }

        // 去重用
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] < lastNum || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);

            subsequence.add(nums[i]);
            dfs(subsequences, subsequence, nums, i + 1, len + 1, nums[i]);
            subsequence.removeLast();
        }
    }
}
