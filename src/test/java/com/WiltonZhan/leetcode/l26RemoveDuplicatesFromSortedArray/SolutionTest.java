package com.WiltonZhan.leetcode.l26RemoveDuplicatesFromSortedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void removeDuplicates() {
        int[] nums1 = new int[]{1, 1, 2};
        int num1 = solution.removeDuplicates(nums1);
        assertEquals(2, num1);
        assertArrayEquals(nums1, new int[] {1, 2, 2});

        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int num2 = solution.removeDuplicates(nums2);
        assertEquals(5, num2);
        assertArrayEquals(nums2, new int[]{0, 1, 2, 3, 4, 2, 2, 3, 3, 4});
    }
}