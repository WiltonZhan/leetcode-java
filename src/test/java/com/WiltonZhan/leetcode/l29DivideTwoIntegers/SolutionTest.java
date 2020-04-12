package com.WiltonZhan.leetcode.l29DivideTwoIntegers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void divide() {
        assertEquals(1073741823, solution.divide(Integer.MAX_VALUE, 2));
        assertEquals(Integer.MAX_VALUE, solution.divide(Integer.MIN_VALUE, -1));
        assertEquals(3, solution.divide(10, 3));
        assertEquals(3, solution.divide(6, 2));
        assertEquals(-2, solution.divide(-7, 3));
    }
}