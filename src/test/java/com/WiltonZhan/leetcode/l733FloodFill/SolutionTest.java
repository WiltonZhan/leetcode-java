package com.WiltonZhan.leetcode.l733FloodFill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void floodFill() {
        int[][] image1 = new int[][]{{1,1,1},{1,1,0}, {1,0,1}};
        int[][] image2 = new int[][]{{2,2,2},{2,2,0},{2,0,1}};
        image1 = solution.floodFill(image1, 1,1, 2);
        for (int i = 0; i < image1.length; i++) {
            assertArrayEquals(image1[i], image2[i]);
        }
        image1 = new int[][]{{0,0,0},{0,1,1}};
        image2 = new int[][]{{0,0,0},{0,1,1}};
        image1 = solution.floodFill(image1, 1, 1, 1);
        for (int i = 0; i < image1.length; i++) {
            assertArrayEquals(image1[i], image2[i]);
        }
    }
}