package com.WiltonZhan.leetcode.l189rotateArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void rotate() {
        int[] nums1 = new int[]{1,2,3,4,5,6,7};
        solution.rotate(nums1, 3);
        assertArrayEquals(nums1, new int[]{5,6,7,1,2,3,4});

        int[] nums2 = new int[]{-1,-100,3,99};
        solution.rotate(nums2, 2);
        assertArrayEquals(nums2, new int[]{3,99,-1,-100});
    }
}