package com.WiltonZhan.leetcode.l35SearchInsertPosition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void searchInsert() {
        assertEquals(2, solution.searchInsert(new int[]{1,3,5,6}, 5));
        assertEquals(1, solution.searchInsert(new int[]{1,3,5,6}, 2));
        assertEquals(4, solution.searchInsert(new int[]{1,3,5,6},7));
        assertEquals(0, solution.searchInsert(new int[]{1,3,5,6}, 0));
    }
}