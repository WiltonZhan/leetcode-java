package com.WiltonZhan.leetcode.l350IntersectionOfTwoArraysII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void intersect() {
//        assertArrayEquals(solution.intersect(new int[]{1,2,2,1}, new int[]{2,2}), new int[]{2,2});
        assertArrayEquals(solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4}), new int[]{4,9});
    }
}