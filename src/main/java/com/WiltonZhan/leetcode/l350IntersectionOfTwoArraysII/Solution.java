package com.WiltonZhan.leetcode.l350IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     *  暴力求解
     */
    public int[] intersect(int[] nums1, int[] nums2) {
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
}
