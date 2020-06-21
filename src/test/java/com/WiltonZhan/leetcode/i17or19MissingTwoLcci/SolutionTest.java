package com.WiltonZhan.leetcode.i17or19MissingTwoLcci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void missingTwo() {
        assertArrayEquals(new int[]{2, 3}, solution.missingTwo(new int[]{1}));
        assertArrayEquals(new int[]{2,3}, solution.missingTwo(new int[]{1,4}));
    }
}