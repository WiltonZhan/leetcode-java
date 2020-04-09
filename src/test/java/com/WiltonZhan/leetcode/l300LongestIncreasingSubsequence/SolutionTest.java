package com.WiltonZhan.leetcode.l300LongestIncreasingSubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void lengthOfLIS() {
        assertEquals(6, solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        assertEquals(4, solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}