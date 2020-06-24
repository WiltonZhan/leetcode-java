package com.WiltonZhan.leetcode.l16ThreeSumClosest;

import java.util.Arrays;

/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。



示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。


提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
 */
public class Solution {
    /**
     * 排序+双指针
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return target;
        }
        int minDiff = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        int closestSum = target;
        for (int i = 0; i < len; i++) {
            int twoSum = target - nums[i];
            int l = i + 1, r = len - 1;
            while (l < r) {
                int tempSum = nums[l] + nums[r];
                if (tempSum < twoSum) {
                    if (minDiff > twoSum - tempSum) {
                        minDiff = twoSum - tempSum;
                        closestSum = tempSum + nums[i];
                    }
                    l++;
                } else if (tempSum > twoSum) {
                    if (minDiff > tempSum - twoSum) {
                        minDiff = tempSum - twoSum;
                        closestSum = tempSum + nums[i];
                    }
                    r--;
                } else {
                    return target;
                }
            }
        }

        return closestSum;
    }
}
