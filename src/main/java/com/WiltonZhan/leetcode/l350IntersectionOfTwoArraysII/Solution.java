package com.WiltonZhan.leetcode.l350IntersectionOfTwoArraysII;

import java.util.*;

/*
350. 两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Solution {
    /**
     *  暴力求解
     */
    public int[] intersect_brute_force(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        List<Integer> intersection = new ArrayList<>();
        Set<Integer> visitedIndices = new HashSet<>();
        for (int item : nums1) {
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] == item && !visitedIndices.contains(i)) {
                    intersection.add(item);
                    visitedIndices.add(i);
                    break;
                }
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }

    /**
     * 排序
     */
    public int[] intersect_sort(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> intersection = new ArrayList<>();
        int len1 = nums1.length, len2 = nums2.length;
        for (int idx1 = 0, idx2 = 0; idx1 < len1 && idx2 < len2;) {
            while (idx1 < len1 && nums1[idx1] < nums2[idx2]) {
                idx1++;
            }
            while (idx1 < len1 && idx2 < len2 && nums1[idx1] == nums2[idx2]) {
                intersection.add(nums1[idx1]);
                idx1++;
                idx2++;
            }
            while (idx1 < len1 && idx2 < len2 && nums2[idx2] < nums1[idx1]) {
                idx2++;
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }

    /**
     * 哈希表
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        List<Integer> intersection = new ArrayList<>();
        // 遍历较短的数组并统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1: nums1) {
            int count = map.getOrDefault(num1, 0) + 1;
            map.put(num1, count);
        }

        // 遍历较长的数组并计算出交集
        for (int num2: nums2) {
            if (map.containsKey(num2)) {
                intersection.add(num2);
                int remainingCount = map.get(num2) - 1;
                if (remainingCount == 0) {
                    map.remove(num2);
                } else {
                    map.put(num2, remainingCount);
                }
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }
}
