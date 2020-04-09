package com.WiltonZhan.leetcode.l55JumpGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void canJump() {
        assertTrue(solution.canJump(new int[]{1,1,1,0}));
        assertTrue(solution.canJump(new int[]{0}));
        assertTrue(solution.canJump(new int[]{2,3,1,1,4}));
        assertFalse(solution.canJump(new int[]{3,2,1,0,4}));
    }
}