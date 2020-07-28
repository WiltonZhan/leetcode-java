package com.WiltonZhan.leetcode.lcci1624PairsWithSum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void pairSums() {
        List<List<Integer>> pairs = solution.pairSums(new int[]{5, 6, 5}, 11);
        assertEquals(1, pairs.size());
        assertNotNull(pairs.get(0));
        assertArrayEquals(new Integer[]{5, 6}, pairs.get(0).toArray());

        pairs = solution.pairSums(new int[]{5,6,5,6}, 11);
        assertEquals(2, pairs.size());
        assertArrayEquals(new Integer[]{5,6}, pairs.get(0).toArray());
        assertArrayEquals(new Integer[]{5,6}, pairs.get(0).toArray());
    }
}