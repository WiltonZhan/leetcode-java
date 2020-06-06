package com.WiltonZhan.leetcode.l128LongestConsecutiveSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void longestConsecutive() {
        assertEquals(3, solution.longestConsecutive(new int[]{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645}));
        assertEquals(7, solution.longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
        assertEquals(3, solution.longestConsecutive(new int[]{1,2,0,1}));
        assertEquals(1, solution.longestConsecutive(new int[]{0}));
        assertEquals(4, solution.longestConsecutive(new int[]{100,4,200,1,3,2}));
        assertEquals(5, solution.longestConsecutive(new int[]{5,4,3,2,1}));
    }
}