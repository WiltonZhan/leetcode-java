package com.WiltonZhan.leetcode.l136SingleNumber;

class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sn = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sn = sn ^ nums[i];
        }
        return sn;
    }
}
