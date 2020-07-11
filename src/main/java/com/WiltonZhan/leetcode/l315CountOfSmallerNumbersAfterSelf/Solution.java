package com.WiltonZhan.leetcode.l315CountOfSmallerNumbersAfterSelf;

import java.util.*;

/*
315. 计算右侧小于当前元素的个数
给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

示例:

输入: [5,2,6,1]
输出: [2,1,1,0]
解释:
5 的右侧有 2 个更小的元素 (2 和 1).
2 的右侧仅有 1 个更小的元素 (1).
6 的右侧有 1 个更小的元素 (1).
1 的右侧有 0 个更小的元素.
 */
public class Solution {
    /**
     * 暴力搜索：超时
     */
    public List<Integer> countSmaller_brute_force(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        int n = nums.length;
        List<Integer> counts = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            counts.add(count);
        }

        return counts;
    }

    /**
     * 二分查找：从右向左扫描，并且保持已扫描部分有序（升序），然后二分查找待扫描数字a在有序数组中的插入位置index，
     * 那么a的右侧比a小的元素个数就是index。随后将a插入有序数组，继续扫描
     */
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }

        int n = nums.length;
        LinkedList<Integer> counts = new LinkedList<>();

        for (int i = n - 2; i >= 0; i--) {
            int num = nums[i];
            int index = findIndex(nums, i + 1, n - 1, num);
            if (index - i >= 0) {
                System.arraycopy(nums, i + 1, nums, i, index - i);
            }
            nums[index] = num;
            counts.addFirst(index - i);
        }

        counts.add(0);
        return counts;
    }

    private int findIndex(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] >= target) {
            left--;
        }
        return left;
    }
}
