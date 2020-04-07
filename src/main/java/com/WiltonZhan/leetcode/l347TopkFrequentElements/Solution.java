package com.WiltonZhan.leetcode.l347TopkFrequentElements;

import java.util.*;

/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> topK = new ArrayList<>();
        if (nums == null || nums.length == 0 || k > nums.length) {
            return topK;
        }

        // 计数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));

        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            heap.offer(entry.getKey());
            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            topK.add(heap.poll());
        }

        return topK;
    }
}
