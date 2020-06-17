package com.WiltonZhan.leetcode.l1014BestSightseeingPair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void maxScoreSightseeingPair() {
        assertEquals(11, solution.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
}