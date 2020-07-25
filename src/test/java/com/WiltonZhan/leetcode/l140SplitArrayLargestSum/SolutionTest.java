package com.WiltonZhan.leetcode.l140SplitArrayLargestSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void splitArray() {
        assertEquals(18, solution.splitArray(new int[]{7,2,5,10,8}, 2));
    }
}