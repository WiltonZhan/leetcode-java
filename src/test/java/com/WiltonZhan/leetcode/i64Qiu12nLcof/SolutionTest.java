package com.WiltonZhan.leetcode.i64Qiu12nLcof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void sumNums() {
        assertEquals(6, solution.sumNums(3));
        assertEquals(45, solution.sumNums(9));
    }
}