package com.WiltonZhan.leetcode.l739DailyTemperatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void dailyTemperatures() {
        assertArrayEquals(new int[]{0,1,4,1,2,1,0,1,0,0}, solution.dailyTemperatures(new int[]{100,65,67,52,63,40,92,44,66,39}));
        assertArrayEquals(new int[]{1,0,0,2,1,0,0,0,0,0}, solution.dailyTemperatures(new int[]{34,80,80,34,34,80,80,80,80,34}));
        assertArrayEquals(new int[]{8,1,5,4,3,2,1,1,0,0}, solution.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70}));
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        assertArrayEquals(new int[]{3,1,1,4,3,1,1,3,1,1,1,1,30,1,3,2,1,25,2,1,19,2,1,3,2,1,11,5,1,1,2,1,3,2,1,2,1,2,1,3,
                        2,1,0,46,3,1,1,1,30,18,5,1,1,2,1,12,1,10,5,1,2,1,1,4,3,1,1,11,1,1,8,1,1,5,1,3,1,1,11,1,3,2,1,1,5,3,2,1,1,0,1,0,3,2,1,0,0,2,1,0},
                solution.dailyTemperatures(new int[]{64,40,49,73,72,35,68,83,35,73,84,88,96,43,74,63,41,95,48,46,89,72,34,85,72,59,87,49,30,32,47,34,74,58,31,75,73,88,64,92,83,64,100,99,
                        81,41,48,83,96,92,82,32,35,68,68,92,73,92,52,33,44,38,47,88,71,50,57,95,33,65,94,44,47,79,41,74,50,67,97,31,68,50,37,70,77,55,48,30,77,100,31,100,69,60,47,95,68,47,33,64}));
    }
}