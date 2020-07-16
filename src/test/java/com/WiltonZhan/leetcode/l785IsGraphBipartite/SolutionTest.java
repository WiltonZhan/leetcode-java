package com.WiltonZhan.leetcode.l785IsGraphBipartite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isBipartite() {
        assertTrue(solution.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
        assertFalse (solution.isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
    }
}