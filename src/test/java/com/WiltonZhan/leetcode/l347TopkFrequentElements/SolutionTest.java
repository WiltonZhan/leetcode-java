package com.WiltonZhan.leetcode.l347TopkFrequentElements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void topKFrequent() {
        assertArrayEquals(new Integer[]{2,1}, solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1}, solution.topKFrequent(new int[]{1}, 1).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{-1}, solution.topKFrequent(new int[]{-1,-1}, 1).toArray(new Integer[]{}));
    }
}