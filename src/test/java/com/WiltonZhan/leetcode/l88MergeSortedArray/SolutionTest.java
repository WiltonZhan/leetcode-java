package com.WiltonZhan.leetcode.l88MergeSortedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void merge() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        assertArrayEquals(nums1, new int[]{1, 2, 2, 3, 5, 6});

        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{1};
        solution.merge(nums3, 0, nums4, 1);
        assertArrayEquals(nums3, new int[]{1});
    }
}