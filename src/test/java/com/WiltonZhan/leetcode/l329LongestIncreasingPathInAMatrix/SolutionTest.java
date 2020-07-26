package com.WiltonZhan.leetcode.l329LongestIncreasingPathInAMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void longestIncreasingPath() {
        assertEquals(4, solution.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        assertEquals(4, solution.longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
    }
}