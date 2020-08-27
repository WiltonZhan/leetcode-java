package com.WiltonZhan.leetcode.l657RobotReturnToOrigin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void judgeCircle() {
        assertTrue(solution.judgeCircle("UD"));
        assertFalse(solution.judgeCircle("LL"));
    }
}