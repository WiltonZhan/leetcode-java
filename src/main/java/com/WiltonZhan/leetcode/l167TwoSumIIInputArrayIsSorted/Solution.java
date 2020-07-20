package com.WiltonZhan.leetcode.l167TwoSumIIInputArrayIsSorted;

import java.util.Arrays;

/*
167. 两数之和 II - 输入有序数组
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Solution {
    /**
     * 双指针
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    /**
     * 二分搜索
     */
    public int[] twoSum_binary_search(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int targetIdx = Arrays.binarySearch(numbers, i + 1, len, target - numbers[i]);
            if (targetIdx > 0) {
                return new int[]{i + 1, targetIdx + 1};
            }
        }
        return null;
    }
}
