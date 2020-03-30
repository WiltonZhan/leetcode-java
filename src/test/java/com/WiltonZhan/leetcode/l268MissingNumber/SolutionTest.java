package com.WiltonZhan.leetcode.l268MissingNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void missingNumber() {
        assertEquals(2, solution.missingNumber(new int[]{3, 0, 1}));
        assertEquals(8, solution.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}