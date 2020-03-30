package com.WiltonZhan.leetcode.l461HammingDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void hammingDistance() {
        assertEquals(2, solution.hammingDistance(1, 4));
    }
}