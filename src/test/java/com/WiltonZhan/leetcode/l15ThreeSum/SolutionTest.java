package com.WiltonZhan.leetcode.l15ThreeSum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void threeSum() {
        List<List<Integer>> result1 = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, result1.size());
    }
}