package com.WiltonZhan.leetcode.lcof64Qiu12n;

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