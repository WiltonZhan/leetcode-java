package com.WiltonZhan.leetcode.l33SearchInRotatedSortedArray;

/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
 */
public class Solution {
    /**
     *
     * 二分查找：关键在于如何每次“丢弃”一半数据
     * 原数组可以看成由两个独立的有序数组组成。从数组中任意取出一个元素，那么这个元素的左右两边必定有一边是完全有序的。
     * 通过判断两个区间的端点情况，可以确定哪一个区间是完全有序的，进而决定是在有完全序区间中查找，还是在部分有序的区间中查找
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if ((l < m - 1 && nums[l] < nums[m - 1]) && (nums[l] <= target && target <= nums[m - 1])) {    // 左区间有序且可能在左区间
                r = m - 1;
            } else if ((m + 1 < r && nums[m + 1] < nums[r]) && (nums[l] <= target && target <= nums[r])) { // 右区间有序且可能在右区间
                l = m + 1;
            } else if ((l < m - 1 && nums[l] < nums[m - 1]) && (target > nums[m - 1])) {    // 左区间有序但不可能在左区间
                l = m + 1;
            } else if ((m + 1 < r && nums[m + 1] < nums[r]) && (target > nums[r])) {    // 右区间有序但不可能在右区间
                r = m - 1;
            } else {
                l++;
                r--;
            }
        }

        return -1;
    }
}
