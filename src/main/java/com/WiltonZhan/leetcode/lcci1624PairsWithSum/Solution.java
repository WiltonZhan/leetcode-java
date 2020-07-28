package com.WiltonZhan.leetcode.lcci1624PairsWithSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
面试题 16.24. 数对和
设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。

示例 1:

输入: nums = [5,6,5], target = 11
输出: [[5,6]]
示例 2:

输入: nums = [5,6,5,6], target = 11
输出: [[5,6],[5,6]]
提示：

nums.length <= 100000
 */
public class Solution {
    /**
     * 排序，然后采用双指夹逼
     */
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return pairs;
        }
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[l]);
                pair.add(nums[r]);
                pairs.add(pair);
                l++;
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return pairs;
    }
}
