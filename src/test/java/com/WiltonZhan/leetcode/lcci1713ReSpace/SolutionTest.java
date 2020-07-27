package com.WiltonZhan.leetcode.lcci1713ReSpace;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void respace() {
        assertEquals(7, solution.respace(new String[]{"looked","just","like","her","brother"}, "jesslookedjustliketimherbrother"));
    }
}