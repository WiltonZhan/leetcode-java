package com.WiltonZhan.leetcode.l26RemoveDuplicatesFromSortedArray;

public class Solution {
    // 使用双指针，单次遍历
    public int removeDuplicates(int[] nums) {
        int p1 = 0; // 当前被修改的数组元素的下标
        int p2 = 0; // 当前遍历到的数组元素的下标
        for(; p2 < nums.length;) {
            nums[p1] = nums[p2];
            while(p2 < nums.length && nums[p2] == nums[p1]) {
                p2++;
            }
            p1++;
        }
        return p1;
    }
}
