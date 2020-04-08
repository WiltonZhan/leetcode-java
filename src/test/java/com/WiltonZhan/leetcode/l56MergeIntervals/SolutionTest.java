package com.WiltonZhan.leetcode.l56MergeIntervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void merge() {
        int[][] intervals1 = solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        assertEquals(3, intervals1.length);
        assertArrayEquals(new int[]{1,6}, intervals1[0]);
        assertArrayEquals(new int[]{8,10}, intervals1[1]);
        assertArrayEquals(new int[]{15,18}, intervals1[2]);

        int[][] intervals2 = solution.merge(new int[][]{{1,4},{4,5}});
        assertEquals(1, intervals2.length);
        assertArrayEquals(new int[]{1,5}, intervals2[0]);

        int[][] intervals3 = solution.merge(new int[][]{{2,3},{1,4},{6,8},{0,7},{9,10}});
        assertEquals(2, intervals3.length);
        assertArrayEquals(new int[]{0,8}, intervals3[0]);
        assertArrayEquals(new int[]{9,10}, intervals3[1]);

        int[][] intervals4 = solution.merge(new int[][]{{4,5},{2,4},{4,6},{3,4},{0,0},{1,1},{3,5},{2,2}});
        assertEquals(3, intervals4.length);
        assertArrayEquals(new int[]{0,0}, intervals4[0]);
        assertArrayEquals(new int[]{1,1}, intervals4[1]);
        assertArrayEquals(new int[]{2,6}, intervals4[2]);
    }
}