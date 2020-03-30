package com.WiltonZhan.leetcode.l118PascalsTriangle;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void generate() {
        List<List<Integer>> triangle1 = solution.generate(5);
        assertEquals(5, triangle1.size());
        assertArrayEquals(new Integer[]{1}, triangle1.get(0).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1, 1}, triangle1.get(1).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1, 2, 1}, triangle1.get(2).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1, 3, 3, 1}, triangle1.get(3).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1, 4, 6, 4, 1}, triangle1.get(4).toArray(new Integer[]{}));
    }
}