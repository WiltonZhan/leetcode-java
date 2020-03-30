package com.WiltonZhan.leetcode.l268MissingNumber;

public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        result ^= 0;

        for(int i = 1; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        result ^= nums.length;
        return result;
    }
}
