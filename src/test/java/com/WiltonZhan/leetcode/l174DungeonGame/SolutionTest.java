package com.WiltonZhan.leetcode.l174DungeonGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void calculateMinimumHP() {
        assertEquals(1, solution.calculateMinimumHP(new int[][]{
                {0, 5},
                {-2, -3}
        }));

        assertEquals(1, solution.calculateMinimumHP(new int[][]{
                {2, 1},
                {1, -1}
        }));
        assertEquals(7, solution.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }
}