package com.WiltonZhan.leetcode.l209MininumSizeSubarraySum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void minSubArrayLen() {
        assertEquals(2, solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}