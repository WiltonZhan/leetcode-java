package com.WiltonZhan.leetcode.l41FirstMissingPositive;

/*
41. 缺失的第一个正数
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1


提示：

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class Solution {
    /**
     * 直接修改原数组，若nums[i] == i + 1，则表示数字i已经出现。对于负数，我们可以直接忽略。
     * 需要进行两次遍历：第一次更新数组，第二次找出没有出现的最小正整数
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int len = nums.length;
        for (int i = 0; i < len;) {
            if (1 <= nums[i] && nums[i] <= len) {
                int idx = nums[i] - 1;
                if (nums[i] == nums[idx]) {
                    i++;
                } else {
                    int temp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = temp;
                }
            } else {
                i++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }
}
