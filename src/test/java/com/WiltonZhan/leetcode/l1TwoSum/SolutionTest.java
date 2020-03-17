package com.WiltonZhan.leetcode.l1TwoSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void twoSum() {
        assertArrayEquals(solution.twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});
    }
}