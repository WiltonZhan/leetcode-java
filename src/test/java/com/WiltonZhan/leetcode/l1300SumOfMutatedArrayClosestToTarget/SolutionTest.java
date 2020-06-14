package com.WiltonZhan.leetcode.l1300SumOfMutatedArrayClosestToTarget;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void findBestValue() {
        assertEquals(3, solution.findBestValue(new int[]{4,9,3},10));
        assertEquals(5, solution.findBestValue(new int[]{2,3,5}, 10));
        assertEquals(11361, solution.findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803));
    }
}