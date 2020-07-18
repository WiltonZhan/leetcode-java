package com.WiltonZhan.leetcode.l1281SubtractTheProductAndSumOfDigitsOfAnInteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void subtractProductAndSum() {
        assertEquals(15, solution.subtractProductAndSum(234));
        assertEquals(21, solution.subtractProductAndSum(4421));
    }
}