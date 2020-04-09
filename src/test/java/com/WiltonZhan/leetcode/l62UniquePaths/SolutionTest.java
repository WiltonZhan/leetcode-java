package com.WiltonZhan.leetcode.l62UniquePaths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void uniquePaths() {
        assertEquals(3, solution.uniquePaths(3,2));
        assertEquals(28, solution.uniquePaths(7,3));
    }
}