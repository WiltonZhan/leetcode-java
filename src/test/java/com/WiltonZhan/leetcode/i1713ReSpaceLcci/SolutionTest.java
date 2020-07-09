package com.WiltonZhan.leetcode.i1713ReSpaceLcci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void respace() {
        assertEquals(7, solution.respace(new String[]{"looked","just","like","her","brother"}, "jesslookedjustliketimherbrother"));
    }
}