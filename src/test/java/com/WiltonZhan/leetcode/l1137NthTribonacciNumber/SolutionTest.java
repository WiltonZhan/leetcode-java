package com.WiltonZhan.leetcode.l1137NthTribonacciNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void tribonacci() {
//        assertEquals(0, solution.tribonacci(0));
//        assertEquals(1, solution.tribonacci(1));
        assertEquals(4, solution.tribonacci(4));
        assertEquals(1389537, solution.tribonacci(25));
    }
}