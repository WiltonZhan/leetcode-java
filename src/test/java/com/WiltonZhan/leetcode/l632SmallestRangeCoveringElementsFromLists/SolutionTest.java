package com.WiltonZhan.leetcode.l632SmallestRangeCoveringElementsFromLists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void smallestRange() {
        List<List<Integer>> nums1 = new ArrayList<>();
        nums1.add(Arrays.asList(4,10,15,24,26));
        nums1.add(Arrays.asList(0,9,12,20));
        nums1.add(Arrays.asList(5,18,22,30));
        assertArrayEquals(new int[]{20,24}, solution.smallestRange(nums1));
    }
}