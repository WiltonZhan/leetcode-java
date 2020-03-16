package com.WiltonZhan.leetcode.l283MoveZeroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void moveZeroes() {
        int[] nums1 = new int[]{0,1,0,3,12};
        solution.moveZeroes(nums1);
        assertArrayEquals(nums1, new int[]{1,3,12,0,0});
        int[] nums2 = new int[]{1,2,3};
        solution.moveZeroes(nums2);
        assertArrayEquals(nums2, new int[]{1,2,3});
        int[] nums3 = new int[]{0,0,0};
        solution.moveZeroes(nums3);
        assertArrayEquals(nums3, new int[]{0,0,0});
        int[] nums4 = new int[]{1,0};
        solution.moveZeroes(nums4);
        assertArrayEquals(nums4, new int[]{1,0});
        int[] nums5 = new int[]{0,1,0};
        solution.moveZeroes(nums5);
        assertArrayEquals(nums5, new int[]{1,0,0});
        int[] nums6 = new int[]{0,0,1};
        solution.moveZeroes(nums6);
        assertArrayEquals(nums6, new int[]{1,0,0});
    }
}