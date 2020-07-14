package com.WiltonZhan.leetcode.l120Triangle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void minimumTotal() {
        List<List<Integer>> triangle = new ArrayList<>();
        for (Integer[] arr: new Integer[][]{{2}, {3,4}, {6,5,7}, {4,1,8,3}}) {
            triangle.add(Arrays.asList(arr));
        }
        assertEquals(11, solution.minimumTotal(triangle));
    }
}