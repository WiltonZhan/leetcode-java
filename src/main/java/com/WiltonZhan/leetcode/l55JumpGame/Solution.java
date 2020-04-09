package com.WiltonZhan.leetcode.l55JumpGame;

/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

       int furthestJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > furthestJump) {
                return false;
            }
            furthestJump = Math.max(furthestJump, nums[i] + i);
        }
        return true;
    }

    public boolean canJump_dp(int[] nums) { // 动态规划
        if (nums == null || nums.length == 0) {
            return true;
        }

        boolean[] reachable = new boolean[nums.length];
        for (int i = 0; i <= nums[0] && i < nums.length; i++) {
            reachable[i] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (reachable[i]) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j >= nums.length - 1) {
                        return true;
                    }
                    reachable[i + j] = true;
                }
            }
        }

        return reachable[nums.length - 1];
    }

    public boolean canJump_backtrack(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        return backtrack(nums, 0);
    }

    private boolean backtrack(int[] nums, int pos) {    // 回溯法，超时
        if (nums[pos] + pos >= nums.length - 1) {
            return true;
        }
        for (int i = 1; i <= nums[pos]; i++) {
            if (backtrack(nums, pos + i)) {
                return true;
            }
        }
        return false;
    }
}
