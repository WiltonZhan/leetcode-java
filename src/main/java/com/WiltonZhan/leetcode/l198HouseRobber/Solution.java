package com.WiltonZhan.leetcode.l198HouseRobber;

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        int len = nums.length;
        int[] money = new int[len];

        money[0] = nums[0];
        if (len == 1) {
            return money[0];
        }
        money[1] = Math.max(money[0], nums[1]);
        if (len == 2) {
            return money[1];
        }

        for(int i = 2; i < len; i++) {
            money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
        }

        return money[len - 1];
    }
}
