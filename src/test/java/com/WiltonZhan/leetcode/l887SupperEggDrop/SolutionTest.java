package com.WiltonZhan.leetcode.l887SupperEggDrop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void superEggDrop() {
        assertEquals(2, solution.superEggDrop(1, 2));
        assertEquals(4, solution.superEggDrop(3, 14));
    }
}