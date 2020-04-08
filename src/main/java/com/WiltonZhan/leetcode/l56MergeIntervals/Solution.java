package com.WiltonZhan.leetcode.l56MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution {
    /**
     * 先对区间进行排序，再合并
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//        sort(intervals);
        List<Integer[]> mergedIntervals = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] interval = intervals[i];
            for (; i < intervals.length && intervals[i][0] <= interval[1]; i++) {
                interval[1] = Math.max(intervals[i][1], interval[1]);
            }
            mergedIntervals.add(new Integer[]{interval[0], interval[1]});
        }

        int[][] result = new int[mergedIntervals.size()][2];
        for (i = 0; i < mergedIntervals.size(); i++) {
            Integer[] interval = mergedIntervals.get(i);
            result[i][0] = interval[0];
            result[i][1] = interval[1];
        }

        return result;
    }

    private void sort(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] < intervals[minPos][0]) {
                    minPos = j;
                }
            }
            swap(intervals, i, minPos);
        }
    }

    private void swap(int[][] intervals, int i, int j) {
        int[] interval = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = interval;
    }
}
