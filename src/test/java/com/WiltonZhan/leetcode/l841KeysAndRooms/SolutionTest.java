package com.WiltonZhan.leetcode.l841KeysAndRooms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void canVisitAllRooms() {
        assertTrue(solution.canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
        assertFalse(solution.canVisitAllRooms(Arrays.asList(Arrays.asList(1,3), Arrays.asList(3,0,1), Arrays.asList(2), Arrays.asList(0))));
    }
}