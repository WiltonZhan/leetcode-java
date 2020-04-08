package com.WiltonZhan.leetcode.l34FindFirstAndLastPositionOfElementInSortedArray;

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
public class Solution {
    /**
     * 二分查找
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                int start = mid;
                while (start - 1 >= 0 && nums[start - 1] == target) {
                    start--;
                }
                int end = mid;
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }
                return new int[]{start, end};
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
