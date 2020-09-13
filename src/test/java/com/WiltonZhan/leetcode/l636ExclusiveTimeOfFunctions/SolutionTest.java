package com.WiltonZhan.leetcode.l636ExclusiveTimeOfFunctions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void exclusiveTime() {
        assertArrayEquals(new int[]{3, 4}, solution.exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")));
    }
}