package com.WiltonZhan.leetcode.l718MaximumLengthOfRepeatedSubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void findLength() {
        assertEquals(3, solution.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
}