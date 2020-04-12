package com.WiltonZhan.leetcode.l69Sqrtx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void mySqrt() {
        assertEquals(46340, solution.mySqrt(Integer.MAX_VALUE));
        assertEquals(0, solution.mySqrt(0));
        assertEquals(2, solution.mySqrt(4));
        assertEquals(3, solution.mySqrt(10));
    }
}