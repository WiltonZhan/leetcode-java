package com.WiltonZhan.leetcode.i29ShunShiZhenDaYinJuZhenLcof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void spiralOrder() {
        assertArrayEquals(new int[]{}, solution.spiralOrder(new int[][]{}));
        assertArrayEquals(new int[]{1,2,3,6,9,8,7,4,5}, solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        assertArrayEquals(new int[]{1,2,3,4,8,12,11,10,9,5,6,7}, solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}