package com.WiltonZhan.leetcode.l16ThreeSumClosest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void threeSumClosest() {
        assertEquals(4, solution.threeSumClosest(new int[]{1, 2, 1}, 4));
        assertEquals(2, solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}