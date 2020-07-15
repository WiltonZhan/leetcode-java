package com.WiltonZhan.leetcode.l96UniqueBinarySearchTrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void numTrees() {
        assertEquals(5, solution.numTrees(3));
    }
}