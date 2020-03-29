package com.WiltonZhan.leetcode.l198HouseRobber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void rob() {
        assertEquals(4, solution.rob(new int[]{1,2,3,1}));
        assertEquals(12, solution.rob(new int[]{2,7,9,3,1}));
    }
}