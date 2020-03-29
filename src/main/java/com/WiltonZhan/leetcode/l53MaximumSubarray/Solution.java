package com.WiltonZhan.leetcode.l53MaximumSubarray;

/**
 * 开辟一个数组sum，其第i个元素表示以nums[i]作为最后一个元素的子数组的最大和。
 *
 * 如果sum[i] < 0，这对最大子序和没有任何帮助，应该丢弃。
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int result = nums[0];
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (sum[i - 1] < 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }

            if (sum[i] > result) {
                result = sum[i];
            }
        }

        return result;
    }
}
