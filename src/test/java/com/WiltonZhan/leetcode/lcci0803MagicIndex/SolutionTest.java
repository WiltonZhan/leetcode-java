package com.WiltonZhan.leetcode.lcci0803MagicIndex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void findMagicIndex() {
        assertEquals(0, solution.findMagicIndex(new int[]{0,2,3,4,5}));
        assertEquals(1, solution.findMagicIndex(new int[]{1,1,1}));
    }
}