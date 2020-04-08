package com.WiltonZhan.leetcode.l162FindPeekElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void findPeakElement() {
        assertEquals(2, solution.findPeakElement(new int[]{1,2,3,1}));
        assertEquals(1, solution.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}