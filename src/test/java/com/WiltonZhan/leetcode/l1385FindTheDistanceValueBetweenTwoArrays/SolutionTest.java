package com.WiltonZhan.leetcode.l1385FindTheDistanceValueBetweenTwoArrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void findTheDistanceValue() {
        assertEquals(2, solution.findTheDistanceValue(new int[]{4,5,8}, new int[]{10,9,1,8}, 2));
        assertEquals(2, solution.findTheDistanceValue(new int[]{1,4,2,3}, new int[]{-4,-3,6,10,20,30}, 3));
        assertEquals(1, solution.findTheDistanceValue(new int[]{2,1,100,3}, new int[]{-5,-2,10,-3,7}, 6));
    }
}