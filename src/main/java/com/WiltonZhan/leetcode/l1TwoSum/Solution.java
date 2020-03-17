package com.WiltonZhan.leetcode.l1TwoSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     *  使用查找表
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{ map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}