package com.WiltonZhan.leetcode.l41FirstMissingPositive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void firstMissingPositive() {
        assertEquals(3, solution.firstMissingPositive(new int[]{1,2,0}));
        assertEquals(2, solution.firstMissingPositive(new int[]{3,4,-1,1}));
        assertEquals(1, solution.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}