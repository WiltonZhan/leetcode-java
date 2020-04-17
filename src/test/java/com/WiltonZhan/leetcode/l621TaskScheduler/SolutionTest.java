package com.WiltonZhan.leetcode.l621TaskScheduler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void leastInterval() {
        assertEquals(8, solution.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        assertEquals(11, solution.leastInterval(new char[]{'A','A','A','B','B','B','C','D','D','E','E'}, 2));
    }
}