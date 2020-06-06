package com.WiltonZhan.leetcode.l128LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
128. 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Solution {
    /**
     * 先排序，再找最长连续序列，注意去重
     */
    public int longestConsecutive_sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            int tempLen = 1;
            while (i < nums.length - 1) {
                if (nums[i] + 1 == nums[i + 1]) {
                    tempLen++;
                    i++;
                } else if (nums[i] == nums[i + 1]) {    // 去重
                    i++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(tempLen, maxLen);
        }

        return maxLen;
    }

    /**
     *  暴力解法：以x为起点，不断去匹配x+1,x+2,x+3,...,x+y
     *  时间复杂度：O(n^2)
     */
    public int longestConsecutive_brute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }

        int maxLen = 1;
        for (int num: numSet) {
            int tempLen = 1;
            for (int i = 1; i <= numSet.size(); i++) {
                if (numSet.contains(num + i)) {
                    tempLen++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(tempLen, maxLen);
        }

        return maxLen;
    }

    /**
     * 暴力解法的优化解法
     * 暴力解法中执行了很多不必要的枚举：如果已知有一个x,x+1,x+2,...,x+y的序列，就不需要再枚举x+1,x+2,...,x+y的序列了。因为后者不可能比前者长
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }

        int maxLen = 1;
        for (int num: numSet) {
            if (!numSet.contains(num - 1)) {
                int tempLen = 1;
                for (int i = 1; i <= numSet.size(); i++) {
                    if (numSet.contains(num + i)) {
                        tempLen++;
                    } else {
                        break;
                    }
                }
                maxLen = Math.max(tempLen, maxLen);
            }
        }

        return maxLen;
    }
}
