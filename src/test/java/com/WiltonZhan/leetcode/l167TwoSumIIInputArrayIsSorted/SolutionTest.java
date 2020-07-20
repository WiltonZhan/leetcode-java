package com.WiltonZhan.leetcode.l167TwoSumIIInputArrayIsSorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{1,2}, solution.twoSum(new int[]{2,7,11,15},9));
    }
}