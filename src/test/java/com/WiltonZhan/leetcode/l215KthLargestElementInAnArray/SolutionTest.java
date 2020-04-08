package com.WiltonZhan.leetcode.l215KthLargestElementInAnArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void findKthLargest() {
        assertEquals(5, solution.findKthLargest(new int[]{3,2,1,5,6,4},2));
        assertEquals(4, solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}