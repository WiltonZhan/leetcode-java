package com.WiltonZhan.leetcode.l334IncreasingTripletSubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void increasingTriplet() {
        assertTrue(solution.increasingTriplet(new int[]{1,2,3,4,5}));
        assertFalse(solution.increasingTriplet(new int[]{5,4,3,2,1}));
    }
}