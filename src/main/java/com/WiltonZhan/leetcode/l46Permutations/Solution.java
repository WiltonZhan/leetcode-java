package com.WiltonZhan.leetcode.l46Permutations;

import java.util.ArrayList;
import java.util.List;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permutations;
        }

        backtrack(nums, 0, permutations, new ArrayList<>());

        return permutations;
    }

    private void backtrack(int[] nums, int size, List<List<Integer>> permutations, List<Integer> permutation) {
        if (size == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int num : nums) {
            if (!permutation.contains(num)) {
                permutation.add(num);
                backtrack(nums, size + 1, permutations, permutation);
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
