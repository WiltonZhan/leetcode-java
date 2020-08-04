package com.WiltonZhan.leetcode.l207CourseSchedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void canFinish() {
        assertFalse(solution.canFinish(3, new int[][]{{1,0},{1,2},{0,1}}));
        assertTrue(solution.canFinish(2, new int[][]{{1,0}}));
        assertFalse(solution.canFinish(2, new int[][]{{0,1},{1,0}}));
    }
}