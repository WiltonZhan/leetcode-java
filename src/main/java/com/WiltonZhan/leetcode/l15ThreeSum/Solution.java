package com.WiltonZhan.leetcode.l15ThreeSum;

import java.util.*;

public class Solution {
    /**
     *  使用查找表
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            Set<Integer> map = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) { // 去重
                int value = target - nums[j];
                if (map.contains(value)) {
                    List<Integer> abc = new ArrayList<>(3);
                    abc.add(nums[i]);
                    abc.add(nums[j]);
                    abc.add(value);
                    result.add(abc);
                    for (; j < nums.length - 1 && nums[j] == nums[j + 1]; j++); // 去重
                    continue;
                }
                map.add(nums[j]);
            }
            for (; i < nums.length - 1 && nums[i] == nums[i + 1]; i++); // 去重
        }

        return result;
    }

    public List<List<Integer>> threeSum_bruteforce(int[] nums) {    // 超时
        List<List<Integer>> combinations = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return combinations;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int sum = -nums[i]; // two-sum
            for (int j = i + 1; j < nums.length; j++) {
                int target = sum - nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == target) {
                        ArrayList<Integer> combination = new ArrayList<>();
                        combination.add(nums[i]);
                        combination.add(nums[j]);
                        combination.add(nums[k]);
                        combinations.add(combination);
                    }
                    while (k + 1 < nums.length && nums[k + 1] == nums[k]) k++;  // 去重
                }
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) j++; // 去重
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++; // 去重
        }

        return combinations;
    }
}
