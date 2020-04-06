package com.WiltonZhan.leetcode.l46Permutations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void permute() {
        List<List<Integer>> permutations1 = solution.permute(new int[]{1,2,3});
        assertEquals(6, permutations1.size());
        assertArrayEquals(new Integer[]{1,2,3}, permutations1.get(0).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1,3,2}, permutations1.get(1).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{2,1,3}, permutations1.get(2).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{2,3,1}, permutations1.get(3).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{3,1,2}, permutations1.get(4).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{3,2,1}, permutations1.get(5).toArray(new Integer[]{}));
    }
}