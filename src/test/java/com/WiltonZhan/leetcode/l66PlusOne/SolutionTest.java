package com.WiltonZhan.leetcode.l66PlusOne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void plusOne() {
        assertArrayEquals(solution.plusOne(new int[]{1,2,3}), new int[]{1,2,4});
        assertArrayEquals(solution.plusOne(new int[]{4,3,2,1}), new int[]{4,3,2,2});
        assertArrayEquals(solution.plusOne(new int[]{0}), new int[]{1});
        assertArrayEquals(solution.plusOne(new int[]{9,9}), new int[]{1,0,0});
    }
}