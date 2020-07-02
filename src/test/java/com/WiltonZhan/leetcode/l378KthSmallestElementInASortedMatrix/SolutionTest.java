package com.WiltonZhan.leetcode.l378KthSmallestElementInASortedMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void kthSmallest() {
        assertEquals(13, solution.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));
    }
}