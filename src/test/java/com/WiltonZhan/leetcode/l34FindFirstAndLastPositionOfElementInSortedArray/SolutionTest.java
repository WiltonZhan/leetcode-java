package com.WiltonZhan.leetcode.l34FindFirstAndLastPositionOfElementInSortedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void searchRange() {
        assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{-99999,-99998,-9999,-999,-99,-9,-1}, 0));
        assertArrayEquals(new int[]{3,4}, solution.searchRange(new int[]{5,7,7,8,8,10},8));
        assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{5,7,7,8,8,10}, 6));
        assertArrayEquals(new int[]{1,1}, solution.searchRange(new int[]{1,2},2));
        assertArrayEquals(new int[]{0,0}, solution.searchRange(new int[]{1}, 1));
    }
}