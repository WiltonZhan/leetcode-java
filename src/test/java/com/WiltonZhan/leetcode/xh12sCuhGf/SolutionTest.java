package com.WiltonZhan.leetcode.xh12sCuhGf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void find_left_repeat_numII() {
        assertArrayEquals(new int[]{-1,-1,0,-1,2}, solution.find_left_repeat_numII(new int[]{1,3,1,2,1}));
    }
}