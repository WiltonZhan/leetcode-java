package com.WiltonZhan.leetcode.xh12sCuhGf;

import java.util.HashMap;
import java.util.Map;

/*
xh-1.2. 求数组左边的重复数 II
给定一维数组，求数组中每个数字前一次出现的位置。如果是第一次出现则返回 -1。

示例：


输入：[1,3,1,2,1]
输出：[-1,-1,0,-1,2]
 */
public class Solution {
    /**
     * 用哈希表记录数字最近一次出现的位置
     */
    public int[] find_left_repeat_numII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = map.getOrDefault(nums[i], -1);
            map.put(nums[i], i);
        }

        return ans;
    }
}
