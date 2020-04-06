package com.WiltonZhan.leetcode.l78Subsets;

import java.util.ArrayList;
import java.util.List;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Solution {
    /**
     *  在没有重复元素的情况下，一个元素个数为n的集合有2^n个子集。
     *  我们可以使用1代表使用某一个元素，0代表不适用某一个元素，这样能用[0,2^n-1]二进制表示来达到子集的目的
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }

        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {   // 1 << j表示第j位为1，将其和i按位与能够得知子集中是否应该包含该元素
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }
}
