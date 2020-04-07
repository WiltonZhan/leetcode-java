package com.WiltonZhan.leetcode.l75SortColors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void sortColors() {
        int[] nums1 = new int[]{0};
        solution.sortColors(nums1);
        assertArrayEquals(new int[]{0}, nums1);

        int[] nums2 = new int[]{1};
        solution.sortColors(nums2);
        assertArrayEquals(new int[]{1}, nums2);

        int[] nums3 = new int[]{2};
        solution.sortColors(nums3);
        assertArrayEquals(new int[]{2}, nums3);

        int[] nums4 = new int[]{2,1,0};
        solution.sortColors(nums4);
        assertArrayEquals(new int[]{0,1,2}, nums4);

        int[] nums5 = new int[]{2,0,2,1,1,0};
        solution.sortColors(nums5);
        assertArrayEquals(new int[]{0,0,1,1,2,2}, nums5);

        int[] nums6 = new int[]{2,0,1};
        solution.sortColors(nums6);
        assertArrayEquals(new int[]{0,1,2}, nums6);

        int[] nums7 = new int[]{1,0};
        solution.sortColors(nums7);
        assertArrayEquals(new int[]{0,1}, nums7);

        int[] nums8 = new int[]{1,2,0};
        solution.sortColors(nums8);
        assertArrayEquals(new int[]{0,1,2}, nums8);
    }
}