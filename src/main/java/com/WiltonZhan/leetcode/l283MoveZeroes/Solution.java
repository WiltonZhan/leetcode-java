package com.WiltonZhan.leetcode.l283MoveZeroes;

class Solution {
    /**
     *  暴力求解
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0){
                i++;
            }
            if (i == nums.length) {
                return;
            }
            int j = i;
            for(; j < nums.length && nums[j] == 0; j++);
            if (j == nums.length) {
                return;
            }
            nums[i] = nums[j];
            nums[j] = 0;
            i++;
        }
    }
}
