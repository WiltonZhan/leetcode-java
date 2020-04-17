package com.WiltonZhan.leetcode.l371SumOfTwoIntegers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void getSum() {
        assertEquals(3, solution.getSum(1, 2));
        assertEquals(1, solution.getSum(-2, 3));
    }
}