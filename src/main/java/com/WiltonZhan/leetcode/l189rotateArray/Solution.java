package com.WiltonZhan.leetcode.l189rotateArray;

class Solution {
    /**
     * 模拟移动步骤，每轮整体右移一个单位
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for(int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = temp;
        }
    }
}
