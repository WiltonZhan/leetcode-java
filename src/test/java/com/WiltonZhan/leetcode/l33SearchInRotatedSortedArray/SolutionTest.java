package com.WiltonZhan.leetcode.l33SearchInRotatedSortedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void search() {
        assertEquals(6, solution.search(new int[]{8,1,2,3,4,5,6,7}, 6));
        assertEquals(3, solution.search(new int[]{1,2,3,4,5,6}, 4));
        assertEquals(4, solution.search(new int[]{4,5,6,7,0,1,2}, 0));
        assertEquals(-1, solution.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}