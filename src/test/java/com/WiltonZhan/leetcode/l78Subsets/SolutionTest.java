package com.WiltonZhan.leetcode.l78Subsets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void subsets() {
        List<List<Integer>> subsets1 = solution.subsets(new int[]{1,2,3});
        assertEquals(8, subsets1.size());
        assertEquals(0, subsets1.get(0).size());
        assertArrayEquals(new Integer[]{1}, subsets1.get(1).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{2}, subsets1.get(2).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1,2}, subsets1.get(3).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{3}, subsets1.get(4).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1,3}, subsets1.get(5).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{2,3}, subsets1.get(6).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1,2,3}, subsets1.get(7).toArray(new Integer[]{}));
    }
}