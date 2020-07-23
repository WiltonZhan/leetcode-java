package com.WiltonZhan.leetcode.l64MinimumPathSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void minPathSum() {
        assertEquals(7, solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}