package com.WiltonZhan.leetcode.l15ThreeSum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void threeSum() {
        List<List<Integer>> result = new ArrayList<>();
        result = solution.threeSum(new int[]{0,0,0,0,0});
        assertEquals(1, result.size());
        result = solution.threeSum(new int[]{-2,0,1,1,2});
        assertEquals(2, result.size());
        result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, result.size());
    }
}