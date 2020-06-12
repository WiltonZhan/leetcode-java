package com.WiltonZhan.leetcode.l15ThreeSum;

import java.util.*;

/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class Solution {
    /**
     *  使用双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int sum = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] > sum) {
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    l++;
                } else {
                    // 去重
                    while (l + 1 < r && nums[l + 1] == nums[l]) l++;
                    while (r - 1 > l && nums[r - 1] == nums[r]) r--;

                    result.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }

        return result;
    }

    /**
     *  使用查找表
     */
    public List<List<Integer>> threeSum_lookup_table(int[] nums) {
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
